package os.g.zone.products.web.pojo.bo;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 接收从数据库查询出来的结果类型
 */
@Data
public class ProductInfoBO implements Serializable {

    /**
     * 产品表主键 product_id
     */
    private Long productId;

    /**
     * 产品名称
     */
    private String productName;

    /**
     * 产品目前上架
     */
    private Integer productStatus;
    /**
     * 产品库存
     */
    private Integer productRepertories;
    /**
     * 产品匹配模式为通用模式下，匹配的权限的最低级别
     */
    private Integer productCommonLevel;
    /**
     * 产品匹配模式
     */
    private Integer productType;
    /**
     * 产品匹配模式为精准模式下，匹配的权限的级别
     */
    private Integer productSpecLevel;
    /**
     * 产品更新时间
     */
    private Timestamp productModifiedTime;
    /**
     *产品删除标志
     */
    private Integer productIsDel;
}
