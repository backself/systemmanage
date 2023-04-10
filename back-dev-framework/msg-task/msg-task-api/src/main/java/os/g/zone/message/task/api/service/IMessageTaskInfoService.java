package os.g.zone.message.task.api.service;

import os.g.zone.message.task.api.dto.MessageTaskInfoDTO;

/**
* @author AA
* @description 针对表【message_task_info(消息任务表)】的数据库操作Service
* @createDate 2023-04-07 19:48:12
*/
public interface IMessageTaskInfoService{
    MessageTaskInfoDTO saveMessageTask(MessageTaskInfoDTO messageTaskInfo);
}
