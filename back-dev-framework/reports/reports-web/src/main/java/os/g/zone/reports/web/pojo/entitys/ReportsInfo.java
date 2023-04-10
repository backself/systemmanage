package os.g.zone.reports.web.pojo.entitys;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 订单信息表
 * @TableName order_info
 */
@TableName(value ="order_info")
@Data
public class ReportsInfo implements Serializable {
    /**
     * 订单id
     */
    @TableId(type = IdType.AUTO)
    private Object orderId;

    /**
     * 产品id
     */
    private Integer productId;

    /**
     * 消费者用户id
     */
    private Integer consumerId;

    /**
     * 订单状态(
默认“00：（异常订单，订单非法）”；
10 00 00 00 00 00：
订单无异常，订单未完成，下单成功，未出库，未支付，用户未取消订单；
10 00 00 00 01 00：
订单无异常，订单未完成，下单成功，未出库，已支付，用户未取消订单；
10 00 00 01 01 00：
订单无异常，订单未完成，下单成功，正在出库，已支付，用户未取消订单；
10 00 00 02 01 00：
订单无异常，订单未完成，下单成功，已出库，已支付，用户未取消订单；
10 00 00 03 01 00：
订单无异常，订单未完成，下单成功，已发货，已支付，用户未取消订单；
10 00 00 04 01 00：
订单无异常，订单未完成，下单成功，物流运输中，已支付，用户未取消订单；
10 00 00 05 01 00：
订单无异常，订单未完成，下单成功，物流派送中，已支付，用户未取消订单；
10 00 00 06 01 00：
订单无异常，订单未完成，下单成功，物流签收，已支付，用户未取消订单；
10 00 00 07 01 00：
订单无异常，订单未完成，下单成功，消费者确认收货，进入7天售后期间，7天后订单自动完成，已支付，用户未取消订单；

10 01 00 08 01 00：
订单无异常，订单已完成，下单成功，已结束，已支付，用户未取消订单；

10 01 01 09 01 00：
订单无异常，订单已完成，下单失败，（出库失败，下发通知），已支付，用户未取消订单；

10 01 01 xx 01 01：
订单无异常，订单已完成，下单失败，(订单流程状态)，（订单是支付状态），用户取消订单；

10 01 01 00 00 11 ：
订单无异常，订单已完成，下单失败，未支付，（用户超时支付，系统取消订单）；

10 01 00 05 01 02 ：
订单无异常，订单已完成，下单成功，派送中，已支付，（用户拒收，进入自动退货阶段）；

10 01 00 06 01 03 ：
订单无异常，订单已完成，下单成功，物流已签收，已支付，（用户退货，进入退货阶段）；
10 01 00 06 01 04：
订单无异常，订单已完成，下单成功，物流已签收，已支付，（用户退货，进入换货阶段）；

00(异常原因)：订单异常，下单失败，其他原因
     */
    private String orderStatus;

    /**
     * 保存换货订单号
     */
    private Integer nextOId;

    /**
     * 订单创建时间
     */
    private Date orderCreateTime;

    /**
     * 订单更新时间
     */
    private Date orderModifiedTime;

    /**
     * 订单删除标识，0：未删除，1：已删除
     */
    private Integer orderIsDel;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}