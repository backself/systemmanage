package os.g.zone.pay.util;

/**
 * @Auther: AA
 * @Date: 2023/4/3 14:01
 * @Description: PayResult
 * @Version 1.0.0
 */

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

/**
 * 通用响应对象
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PayResult<T> implements Serializable {

    /**
     * 状态码
     */
    private Integer state;
    /**
     * 消息
     */
    private String message;
    /**
     * 数据
     */
    private T data;

    /**
     * 创建响应结果对象，表示"成功"，不封装其它任何数据
     * @return 响应结果对象
     */
    public static PayResult<Void> success() {
        return success("OK");
    }

    /**
     * 只返回数据不返回提示信息
     * @Auther: AA
     * @Date: 2023/3/29 22:17
     * @Version 1.0.0
     */
    public static <T> PayResult<T> success(T data) {
        return success(null,data);
    }
    public static PayResult<Void> success(String message){
        PayResult jsonResult=new PayResult();
        jsonResult.setState(ReplyCode.RES_SUCCESS.getValue());
        jsonResult.setMessage(message);
        jsonResult.setData(null);
        return jsonResult;
    }
    /**
     * 创建响应结果对象，表示"成功"，且封装客户端期望响应的数据
     * @param data 客户端期望响应的数据
     * @return 响应结果对象
     */
    public static <T> PayResult<T> success(String message, T data) {
        PayResult<T> jsonResult = new PayResult<>();
        jsonResult.setState(ReplyCode.RES_SUCCESS.getValue());
        jsonResult.setData(data);
        jsonResult.setMessage(message);
        return jsonResult;
    }

    /**
     * 创建响应结果对象，表示"失败"，且封装"失败"的描述
     *
     * @param replyCode "失败"的状态码
     * @param e            "失败"时抛出的异常对象
     * @return 响应结果对象
     */
    public static PayResult<Void> failed(ReplyCode replyCode, Throwable e) {
        return failed(replyCode, e.getMessage());
    }

    /**
     * 创建响应结果对象，表示"失败"，且封装"失败"的描述
     *
     * @param replyCode "失败"的状态码
     * @param message      "失败"的描述文本
     * @return 响应结果对象
     */
    public static PayResult<Void> failed(ReplyCode replyCode, String message) {
        PayResult<Void> jsonResult = new PayResult<>();
        jsonResult.setState(replyCode.getValue());
        jsonResult.setMessage(message);
        return jsonResult;
    }

}

