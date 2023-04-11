package os.g.zone.messages.queue.stocks;

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
@RocketMQMessageListener(topic = QueueMsgTopics.STOCKS,consumerGroup = "message_publish_stocks",selectorExpression = QueueMsgTags.SYSTEM_DEFAULT_BC)
public class StockTaskMsgBroadCastConsumer implements RocketMQListener<String> {

    @Autowired
    private WebSocketService webSocketService;

    @Override
    public void onMessage(String message) {
        log.debug("接收到库存广播消息：【{}】=======【{}】=======",QueueMsgTopics.STOCKS,message);
        MessageTaskInfoDTO msg = JSONObject.parseObject(message,MessageTaskInfoDTO.class);
        BCMessageVO wsMsg = new BCMessageVO();
        JSONObject content = new JSONObject();

        wsMsg.setDisplayPosition(DisplayPositionEnum.CARD_STOCKS.getPosition());
        content.put("count",1);
        content.put("type",1);
        wsMsg.setContent(content.toJSONString());
        webSocketService.sendToAllMessage(wsMsg);
    }
}
