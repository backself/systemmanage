package os.g.zone.products.web.pojo.entitys;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalTime;

/**
 * 产品数据表对应实体
 */
@Data
@TableName("product_info")
public class ProductInfo implements Serializable {
    /**
     * 产品表主键 product_id
     */
    @TableId(value = "product_id",type = IdType.AUTO)
    private Long productId;

    /**
     * 产品名称
     */
    private String productName;
    /**
     * 产品创建时间
     */
    private Timestamp productCreateTime;
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
