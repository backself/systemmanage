package os.g.zone.messages.socket.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import os.g.zone.messages.commons.UsersOnlineRedisEnum;
import os.g.zone.messages.socket.vo.BCMessageVO;
import os.g.zone.messages.socket.vo.P2PMessageVO;
import os.g.zone.messages.socket.service.WebSocketService;

import javax.websocket.Session;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Service
public class WebSocketServiceImpl implements WebSocketService {

    @Autowired
    private RedisTemplate redisTemplate;// 使用key - map方式将在线用户的用户id和sessionId持久化到redis中

    // 缓存当前所有链接
    private static final ConcurrentHashMap<String,Session> onlineUsers = new ConcurrentHashMap<>();
    @Override
    public int addSocketSessionToRedis(String userId, Session session) {

        boolean tmp = containtSocketSessionFromRedis(userId);
        if(tmp){
            log.debug("用户{}已在线。",userId);
            try {
                session.getBasicRemote().sendText("您已在其他设备登录,此处将收不到消息");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return 0;
        }

        String key = UsersOnlineRedisEnum.USER_LOGIN.getKey();
        redisTemplate.opsForHash().put(key,String.valueOf(userId),session.getId());
        log.debug("用户{}上线。",userId);
        try {
            session.getBasicRemote().sendText("您已上线");
            session.getBasicRemote().sendText("当前在线人数："+countAllUsersFromRedis());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // 保存到map缓存中
        onlineUsers.put(userId,session);
        return 0;
    }

    @Override
    public int deleteSocketSessionFromRedis(String userId) {

        if (redisTemplate.opsForHash().get(UsersOnlineRedisEnum.USER_LOGIN.getKey(), userId) == null) {
            log.debug("用户{}已下线",userId);
            return 0;
        }
        redisTemplate.opsForHash().delete(UsersOnlineRedisEnum.USER_LOGIN.getKey(), userId);
        onlineUsers.remove(userId);
        log.debug("用户{}下线",userId);
        return 1;
    }

    @Override
    public int updateSocketSessionInRedis(String userId, Session newSession) {
        return 0;
    }

    @Override
    public boolean containtSocketSessionFromRedis(String userId) {
        return redisTemplate.opsForHash().get(UsersOnlineRedisEnum.USER_LOGIN.getKey(), userId) != null;
    }

    @Override
    public int countAllUsersFromRedis() {
        long count = redisTemplate.opsForHash().size(UsersOnlineRedisEnum.USER_LOGIN.getKey());
        return (int)count;
    }

    @Override
    public int sendToUserMessage(P2PMessageVO p2PMessageVO) {
        log.debug("消息持久化处理：{}用户向{}用户发送消息{}。", p2PMessageVO.getSendUId(),
                p2PMessageVO.getReciveUId(), p2PMessageVO.getContent());
        // 获取接收方的session会话
        String targetId = String.valueOf(p2PMessageVO.getReciveUId());
        Session reciver = onlineUsers.get(targetId);
        try {
            String msg = p2PMessageVO.getSendUId() +"用户发来："+ p2PMessageVO.getContent();
            reciver.getBasicRemote().sendText(msg);
        } catch (IOException e) {
            log.error("消息发送异常：{}",e.getMessage());
            throw new RuntimeException(e);
        }
        return 0;
    }

    @Override
    public int sendToAllMessage(BCMessageVO bcMessageVO) {

        for (Map.Entry<String, Session> entry : onlineUsers.entrySet()) {
            try {
                 entry.getValue().getBasicRemote().sendText(bcMessageVO.toString());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return 0;
    }

}
