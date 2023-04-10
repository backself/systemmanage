package os.g.zone.messages.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;
import os.g.zone.messages.socket.service.WebSocketService;
import os.g.zone.messages.socket.server.WebSocketServer;

/**
 * websocket 配置类
 * 在配置类上加入注解 @EnableWebSocket，表明开启 WebSocket
 */
@EnableWebSocket
@Configuration
public class WebSocketConfiguration {
    /**
     * 内部实例化 ServerEndpointExporter 的 Bean，该 Bean 会自动注册 @ServerEndpoint 注解声明的端点
     * @return
     */
    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }

    @Autowired
    private void setWebSocketService(WebSocketService webSocketService){
        WebSocketServer.webSocketService = webSocketService;
    }
}
