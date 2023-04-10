package os.g.zone.messages;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import os.g.zone.messages.socket.vo.BCMessageVO;

/**
 * rocketMQ测试类
 */
@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT ) // 因为单元测试时不会启动服务器所以需要添加该配置
public class RocketMQTest {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @Test
    public void producerMessageTest() throws InterruptedException {
        BCMessageVO bcMessageVO = new BCMessageVO();
        bcMessageVO.setDisplayPosition("0");
        bcMessageVO.setContent("这是消息内容");
        String jb = JSONObject.toJSONString(bcMessageVO);
        rocketMQTemplate.convertAndSend("AA", jb);
        log.debug("发送消息=========================String:{}=========================Object{}",jb,bcMessageVO);
    }

}

