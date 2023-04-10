package os.g.zone.messages.pojo.entitys;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalTime;

/**
 * 消息实体类
 */
@Data
public class MessageInfo implements Serializable {
    // 消息id
    private Long mId;
    //任务id
    private Long tId;
    //接收消息的用户id
    private Long reciveUId;
    //发送消息的用户id
    private Long sendUId;
    //消息创建时间
    private LocalTime mCreateTime;
    //当前消息状态
    private Integer mStatus;
    //消息更新时间
    private LocalTime mModifiedTime;
    //执行消息重发约定的时间
    private LocalTime mAgainTime;
    //当前消息删除标志
    private Integer mIsDel;
}
