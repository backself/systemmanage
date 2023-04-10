package os.g.zone.message.task.web.mappers;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import os.g.zone.message.task.web.pojo.entitys.MessageTaskInfo;

import java.util.HashMap;

@SpringBootTest
@Slf4j
class TestMappers {
	@Autowired
	private MessageTaskInfoMapper messageTaskInfoMapper;

	@Test
	void test() {
		MessageTaskInfo messageTaskInfo = new MessageTaskInfo();
		HashMap<String,String> content = new HashMap<>();
		content.put("orderId","1234567");
		content.put("type","1");
		String contentString = JSON.toJSONString(content);
		String uList = "";
		messageTaskInfo.setUId(1L);
		messageTaskInfo.setReciveUList(uList);
		messageTaskInfo.setTaskContent(contentString);
		messageTaskInfoMapper.insert(messageTaskInfo);
		log.debug(messageTaskInfo.getTaskId().toString());
	}

}
