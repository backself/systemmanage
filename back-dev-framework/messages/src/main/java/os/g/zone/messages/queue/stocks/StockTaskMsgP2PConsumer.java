package os.g.zone.messages.queue.stocks;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;
import os.g.zone.commons.queue.consts.QueueMsgTags;
import os.g.zone.commons.queue.consts.QueueMsgTopics;
import os.g.zone.message.task.api.dto.MessageTaskInfoDTO;

/**
 * 执行消息推送的消费者
 * ---消费者
 * 再接收监听消息时，使用自定义的消息对象会出现转换对象类型异常：
 *  原因是在集成redis时引用了其他序列化类型，所以导致此处抛出异常
 */
@Slf4j
@RocketMQMessageListener(
        topic = QueueMsgTopics.STOCKS,
        consumerGroup = "message_publish_stocks_sys_deault_p2p",
        selectorExpression = QueueMsgTags.SYSTEM_DEFAULT_P2P)
@Component
public class StockTaskMsgP2PConsumer implements RocketMQListener<String> {

    @Override
    public void onMessage(String message) {
        log.debug("接收到库存P2P消息：【{}】=======【{}】=======",QueueMsgTopics.STOCKS,message);
        MessageTaskInfoDTO msg = JSONObject.parseObject(message, MessageTaskInfoDTO.class);
    }
}
