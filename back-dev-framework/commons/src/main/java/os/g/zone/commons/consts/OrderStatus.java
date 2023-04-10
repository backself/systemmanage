package os.g.zone.commons.consts;

/**
 * @Auther: AA
 * @Date: 2023/3/29 23:58
 * @Description: OrderStatus
 * @Version 1.0.0
 */
public enum OrderStatus {
    DEFAULT_ERROR_CODE("xx"), // 默认的其他异常可替换码的内容
    DEFAULT_ERROR_CODE_INDEX("3"), // 默认的其他异常可替换码的位置
    /**
     * 默认 值 00：（异常订单，订单非法）
     * @Auther: AA
     * @Date: 2023/4/4 20:31
     * @Version 1.0.0
     */
    ILLEGAL_EXCEPTION_ORDER("00-00-00-00-00-00"),

    /**
     * 订单无异常，订单未完成，下单成功，未出库，未支付，用户未取消订单
     * @Auther: AA
     * @Date: 2023/4/4 20:31
     * @Version 1.0.0
     */
    READY_ORDER("10-00-00-00-00-00"),
    /**
     * 订单无异常，订单未完成，下单成功，未出库，已支付，用户未取消订单
     * @Auther: AA
     * @Date: 2023/4/4 20:31
     * @Version 1.0.0
     */
    READY_ORDER_PAYED("10-00-00-00-01-00"),
    /**
     * 订单无异常，订单未完成，下单成功，正在出库，已支付，用户未取消订单
     * @Auther: AA
     * @Date: 2023/4/4 20:31
     * @Version 1.0.0
     */
    ORDER_PAYED_EXPORT("10-00-00-01-01-00"),
    /**
     * 订单无异常，订单未完成，下单成功，已出库，已支付，用户未取消订单
     * @Auther: AA
     * @Date: 2023/4/4 20:37
     * @Version 1.0.0
     */
    ORDER_PAYED_EXPORTED("10-00-00-02-01-00"),
    /**
     * 订单无异常，订单未完成，下单成功，已发货，已支付，用户未取消订单
     * @Auther: AA
     * @Date: 2023/4/4 20:37
     * @Version 1.0.0
     */
    ORDER_PAYED_EXPRESS("10-00-00-03-01-00"),

    /**
     * 订单无异常，订单未完成，下单成功，物流运输中，已支付，用户未取消订单
     * @Auther: AA
     * @Date: 2023/4/4 20:37
     * @Version 1.0.0
     */
    ORDER_PAYED_EXPRESSING("10-00-00-04-01-00"),

    ORDER_PAYED_EXPRESS_DELIVER("10-00-00-05-01-00"), // 订单无异常，订单未完成，下单成功，物流派送中，已支付，用户未取消订单；

    ORDER_PAYED_EXPRESS_RECEIVED("10-00-00-06-01-00"), // 订单无异常，订单未完成，下单成功，物流签收，已支付，用户未取消订单；
    ORDER_AFTER_SERVICE("10-00-00-07-01-00"), // 订单无异常，订单未完成，下单成功，消费者确认收货，进入7天售后期间，7天后订单自动完成，已支付，用户未取消订单；
    ORDER_FINISHED("10-01-00-08-01-00"), // 订单无异常，订单已完成，下单成功，已结束，已支付，用户未取消订单；
    ORDER_FAILED_BY_EXPORT("10-01-01-09-01-00"), // 订单无异常，订单已完成，下单失败，（出库失败，下发通知），已支付，用户未取消订单；

    ORDER_FAILED_BY_OTHERS("10-01-01-xx-01-01"), // 订单无异常，订单已完成，下单失败，(订单流程状态)，（订单是支付状态），用户取消订单；
    ORDER_FAILED_BY_TIMED("10-01-01-00-00-11"), // 订单无异常，订单已完成，下单失败，未支付，（用户超时支付，系统取消订单）；
    ORDER_FAILED_BY_REFUSED("10-01-00-05-01-02"), // 订单无异常，订单已完成，下单成功，派送中，已支付，（用户拒收，进入自动退货阶段）；
    ORDER_FAILED_BY_CANCEL("10-01-00-06-01-03"), // 订单无异常，订单已完成，下单成功，物流已签收，已支付，（用户退货，进入退货阶段）；
    ORDER_FAILED_BY_REPLACE("10-01-00-06-01-04"); // 订单无异常，订单已完成，下单成功，物流已签收，已支付，（用户退货，进入换货阶段）；

    private String errCode;
    OrderStatus(String errCode){
        this.errCode = errCode;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public static final Boolean setSpecErrorCodeInOrderFlow(String distCode){
        String sourceErrorCode = OrderStatus.ORDER_FAILED_BY_OTHERS.errCode;
        String[] temp = sourceErrorCode.split("-");
        int index = Integer.valueOf(OrderStatus.DEFAULT_ERROR_CODE_INDEX.errCode);
        if (OrderStatus.DEFAULT_ERROR_CODE.errCode.equals(temp[index])){
            // 如果默认位置的异常码为默认值那么才可以进行修改，否则修改失败
            temp[index] = distCode;
            return true;
        }else {
            return false;
        }
    }
}
