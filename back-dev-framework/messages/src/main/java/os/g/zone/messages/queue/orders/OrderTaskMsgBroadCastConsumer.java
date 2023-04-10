package os.g.zone.messages.queue.orders;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import os.g.zone.commons.queue.consts.QueueMsgTags;
import os.g.zone.commons.queue.consts.QueueMsgTopics;
import os.g.zone.message.task.api.dto.MessageTaskInfoDTO;
import os.g.zone.messages.commons.DisplayPositionEnum;
import os.g.zone.messages.socket.vo.BCMessageVO;
import os.g.zone.messages.socket.service.WebSocketService;

/**
 * 执行消息推送的消费者
 * ---消费者
 * 再接收监听消息时，使用自定义的消息对象会出现转换对象类型异常：
 *  原因是在集成redis时引用了其他序列化类型，所以导致此处抛出异常
 */
@Slf4j
@Component
@RocketMQMessageListener(topic = QueueMsgTopics.ORDERS,consumerGroup = "message_publish",selectorExpression = QueueMsgTags.SYSTEM_DEFAULT_BC)
public class OrderTaskMsgBroadCastConsumer implements RocketMQListener<String> {

    @Autowired
    private WebSocketService webSocketService;

    @Override
    public void onMessage(String message) {
        log.debug("接收到订单广播消息：【{}】=======【{}】=======",QueueMsgTopics.ORDERS,message);
        MessageTaskInfoDTO msg = JSONObject.parseObject(message,MessageTaskInfoDTO.class);
        BCMessageVO wsMsg = new BCMessageVO();
        wsMsg.setDisplayPosition(DisplayPositionEnum.CARD_ORDERS.getPosition());
        wsMsg.setContent(msg.getTaskContent());
        webSocketService.sendToAllMessage(wsMsg);
    }
}
