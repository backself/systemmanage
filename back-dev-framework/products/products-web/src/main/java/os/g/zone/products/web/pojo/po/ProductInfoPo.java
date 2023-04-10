package os.g.zone.products.web.pojo.po;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 作为被productmapper调用的参数
 */
@Data
public class ProductInfoPo implements Serializable {

    private Long productId;
    private String productName;
    /**
     * 产品创建时间
     */
    @TableField("product_create_time")
    private Timestamp productCreateTime;
    /**
     * 产品目前上架
     */
    @TableField("product_status")
    private Integer productStatus;
    /**
     * 产品库存
     */
    @TableField("product_repertories")
    private Integer productRepertories;
    /**
     * 产品匹配模式为通用模式下，匹配的权限的最低级别
     */
    @TableField("product_common_level")
    private Integer productCommonLevel;
    /**
     * 产品匹配模式
     */
    @TableField("product_type")
    private Integer productType;
    /**
     * 产品匹配模式为精准模式下，匹配的权限的级别
     */
    @TableField("product_spec_level")
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
