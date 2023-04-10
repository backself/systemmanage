package os.g.zone.message.task.web.pojo.entitys;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 消息任务表
 * @TableName message_task_info
 */
@TableName(value ="message_task_info")
@Data
public class MessageTaskInfo implements Serializable {
    /**
     * 任务id
     */
    @TableId(type = IdType.AUTO)
    private Long taskId;

    /**
     * 任务创建者用户id
     */
    private Long uId;

    /**
     * 任务内容
     */
    private String taskContent;

    /**
     * 任务创建时间
     */
    private Date taskCreateTime;

    /**
     * 任务进行状态（0：待执行，默认值；1：正在执行；3：执行结束，但有拒绝接收信息的用户；4：执行结束：但有约定接受消息时间的用户；5：执行结束，全部接受完成；6：执行结束，被推迟执行；7：执行结束，任务异常，异常原因保存在task_execption字段中；）
     */
    private Integer taskStatus;

    /**
     * 任务更新时间
     */
    private Date taskModifiedTime;

    /**
     * 任务接收用户列表
     */
    private String reciveUList;

    /**
     * 执行任务时间范围内的结束时间
     */
    private Date executeEndTime;

    /**
     * 执行任务时间范围内的开始时间
     */
    private Date executeStartTime;

    /**
     * 任务的级别（0：默认通知消息；1：重要消息；2：加急消息）
     */
    private Integer taskLevel;

    /**
     * 任务执行异常原因
     */
    private String taskExecption;

    /**
     * 任务删除标志：0：未删除，1：已删除
     */
    private Integer taskIsDel;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}