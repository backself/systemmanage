package os.g.zone.orders.pojo.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 视图传输 接收请求对象类
 * @Auther: AA
 * @Date: 2023/3/30 0:03
 * @Version 1.0.0
 */
@Data
public class OrderInfoVO implements Serializable {
    /**
     * 订单id
     */
    @TableId(type = IdType.AUTO)
    private Long orderId;

    /**
     * 产品id
     */
    private Long productId;

    /**
     * 订单创建时间
     */
    private Date orderCreateTime;

    /**
     * 订单更新时间
     */
    private Date orderModifiedTime;

    /**
     * 订单状态
     * @Auther: AA
     * @Date: 2023/3/29 23:59
     * @Version 1.0.0
     */
    private String orderStatus;

    /**
     * 消费者用户id
     */
    private Integer consumerId;

    /**
     * 保存换货订单号
     */
    private Long nextOId;

    /**
     *订单删除标识
     * 0：未删除，1：已删除
     */
    private Integer orderIsDel;

}