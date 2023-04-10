package os.g.zone.pay.util;

/**
 * 错误代码枚举类型
 */
public enum ReplyCode {

    /**
     * 响应成功
     */
    RES_SUCCESS(200),
    /**
     * 响应——常规失败
     */
    RES_ERROR(100),
    /**
     * 请求参数错误
     */
    REQ_PARAMS_ERROR(400),
    /**
     * 认证未通过
     */
    UNAUTHORIZED(401),
    /**
     * 权限不足，禁止访问
     */
    FORBIDDEN(403),
    /**
     * 资源未找到
     */
    REQ_NOT_FOUND(404),
    /**
     * 不在接受请求的范围内
     */
    REQ_NOT_ACCEPTABLE(406),
    /**
     * 拒绝连接
     */
    CONFLICT(409),
    /**
     * 系统级异常
     */
    SYSTEM_INTERNAL_ERROR(500);

    private final Integer value;

    ReplyCode(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

}
