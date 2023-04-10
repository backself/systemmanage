package os.g.zone.messages.socket.service;

import os.g.zone.messages.socket.vo.BCMessageVO;
import os.g.zone.messages.socket.vo.P2PMessageVO;

import javax.websocket.Session;

public interface WebSocketService {

    /**
     * 在redis中增加在线用户
     * @param userId 新增用户id
     * @param session 新增用户的session
     * @return
     */
    int addSocketSessionToRedis(String userId, Session session);

    /**
     * 从redis中删除在线用户
     * @param userId 删除的用户id
     * @return
     */
    int deleteSocketSessionFromRedis(String userId);

    /**
     * 更新redis中指定在线用户的session状态
     * @param userId 指定的userId
     * @param newSession 新的session状态
     * @return
     */
    int updateSocketSessionInRedis(String userId,Session newSession);

    /**
     * 判断在线用户中是否存在指定用户
     * @param userId 指定用户id
     * @return
     */
    boolean containtSocketSessionFromRedis(String userId);

    int countAllUsersFromRedis();

    /**
     * 发送消息到指定用户
     * @param p2PMessageVO 消息对象
     * @return
     */
    int sendToUserMessage(P2PMessageVO p2PMessageVO);

    /**
     * 发送给当前所有在线用户消息
     * @param BCMessageVO 消息对象
     * @return
     */
    int sendToAllMessage(BCMessageVO BCMessageVO);


}
