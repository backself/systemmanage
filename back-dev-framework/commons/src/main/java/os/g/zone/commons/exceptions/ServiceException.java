package os.g.zone.commons.exceptions;


import lombok.Data;
import lombok.EqualsAndHashCode;
import os.g.zone.commons.consts.ReplyCode;

/**
 * 自定义异常类
 * 处理业务时抛出的异常
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ServiceException extends RuntimeException {

    private ReplyCode replyCode;

    public ServiceException(ReplyCode replyCode, String message) {
        super(message);
        setReplyCode(replyCode);
    }

}
