package os.g.zone.message.task.web.service.impl;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import os.g.zone.message.task.api.dto.MessageTaskInfoDTO;
import os.g.zone.message.task.api.service.IMessageTaskInfoService;
import org.springframework.stereotype.Service;
import os.g.zone.message.task.web.mappers.MessageTaskInfoMapper;
import os.g.zone.message.task.web.pojo.entitys.MessageTaskInfo;

/**
* @author AA
* @description 针对表【message_task_info(消息任务表)】的数据库操作Service实现
* @createDate 2023-04-07 19:48:12
*/
@Service
@DubboService
public class IMessageTaskInfoServiceImpl implements IMessageTaskInfoService {

    @Autowired
    private MessageTaskInfoMapper messageTaskInfoMapper;
    @Override
    public MessageTaskInfoDTO saveMessageTask(MessageTaskInfoDTO messageTaskInfoDTO) {
        MessageTaskInfo messageTaskInfo = new MessageTaskInfo();
        BeanUtils.copyProperties(messageTaskInfoDTO,messageTaskInfo);
        messageTaskInfoMapper.insert(messageTaskInfo);
        BeanUtils.copyProperties(messageTaskInfo,messageTaskInfoDTO);
        return messageTaskInfoDTO;
    }
}




