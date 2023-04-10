package os.g.zone.commons.exceptions.handler;


import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import os.g.zone.commons.exceptions.ServiceException;
import os.g.zone.commons.results.JsonResult;
import os.g.zone.commons.consts.ReplyCode;

/**
 * 全局异常处理器
 */
@RestControllerAdvice
@Slf4j
public class GlobalControllerExceptionHandler {

    /**
     * 处理业务异常
     */
    @ExceptionHandler({ServiceException.class})
    public JsonResult<Void> handleCoolSharkServiceException(ServiceException e) {
        log.debug("出现业务异常，业务错误码={}，描述文本={}", e.getReplyCode().getValue(), e.getMessage());
        e.printStackTrace();
        JsonResult<Void> result = JsonResult.failed(e);
        log.debug("即将返回：{}", result);
        return result;
    }

    /**
     * 处理绑定异常（通过Validation框架验证请求参数时的异常）
     */
    @ExceptionHandler(BindException.class)
    public JsonResult<Void> handleBindException(BindException e) {
        log.debug("验证请求数据时出现异常：{}", e.getClass().getName());
        e.printStackTrace();
        String message = e.getBindingResult().getFieldError().getDefaultMessage();
        JsonResult<Void> result = JsonResult.failed(ReplyCode.REQ_PARAMS_ERROR, message);
        log.debug("即将返回：{}", result);
        return result;
    }

    /**
     * 处理系统（其它）异常
     */
    @ExceptionHandler({Throwable.class})
    public JsonResult<Void> handleSystemError(Throwable e) {
        log.debug("出现系统异常，异常类型={}，描述文本={}", e.getClass().getName(), e.getMessage());
        e.printStackTrace();
        JsonResult<Void> result = JsonResult.failed(ReplyCode.SYSTEM_INTERNAL_ERROR, e);
        log.debug("即将返回：{}", result);
        return result;
    }
}