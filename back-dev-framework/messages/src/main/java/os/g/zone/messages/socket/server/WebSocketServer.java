package os.g.zone.messages.socket.server;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import os.g.zone.messages.commons.DisplayPositionEnum;
import os.g.zone.messages.socket.service.WebSocketService;
import os.g.zone.messages.socket.vo.BCMessageVO;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

/**
 * websocket 注册的 服务端点，初始化时会将有@ServerEndpoint注解的类实例化为服务端点
 */
@Slf4j
@ServerEndpoint("/websocket/{userId}")
@Component
public class WebSocketServer {

    public static WebSocketService webSocketService;

    /**
     * 建立链接
     * @param userId
     * @param session
     */
    @OnOpen
    public void openConnect(@PathParam(value="userId") String userId, Session session){
        webSocketService.addSocketSessionToRedis(userId,session);
        // 有人上线通知所有人
        BCMessageVO<String> bcMessageVO = new BCMessageVO<>();
        bcMessageVO.setDisplayPosition(DisplayPositionEnum.CARD_ONLINE.getPosition());
        JSONObject content = new JSONObject();
        content.put("count",1);
        content.put("type",1);
        bcMessageVO.setContent(content.toJSONString());
        webSocketService.sendToAllMessage(bcMessageVO);
    }

    /**
     * 监听消息
     * @param message 客户端发送到服务端的消息
     * @param session 客户端session
     */
    @OnMessage
    public void onMessage(String message, Session session){
        log.debug("收到消息：{}。",message);
    }

    /**
     * 断开链接
     */
    @OnClose
    public void onClose(@PathParam("userId") String userId){
        webSocketService.deleteSocketSessionFromRedis(userId);
        // 有人下线通知所有人
        BCMessageVO<String> bcMessageVO = new BCMessageVO<>();
        bcMessageVO.setDisplayPosition(DisplayPositionEnum.CARD_ONLINE.getPosition());
        JSONObject content = new JSONObject();
        content.put("changeCount",-1);
        bcMessageVO.setContent(content.toJSONString());
        webSocketService.sendToAllMessage(bcMessageVO);
    }

    /**
     * 链接异常
     * @param error 异常
     * @param userId 异常的用户id
     */
    @OnError
    public void onError(@PathParam("userId") String userId, Throwable error){
        webSocketService.deleteSocketSessionFromRedis(userId);
        // 有人下线通知所有人
        BCMessageVO<String> bcMessageVO = new BCMessageVO<>();
        bcMessageVO.setDisplayPosition(DisplayPositionEnum.CARD_ONLINE.getPosition());
        JSONObject content = new JSONObject();
        content.put("changeCount",-1);
        bcMessageVO.setContent(content.toJSONString());
        webSocketService.sendToAllMessage(bcMessageVO);
        error.printStackTrace();
    }
}
