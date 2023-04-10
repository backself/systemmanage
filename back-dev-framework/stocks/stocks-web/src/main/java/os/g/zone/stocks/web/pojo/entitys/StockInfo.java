package os.g.zone.stocks.web.pojo.entitys;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 产品信息表
 * @TableName product_info
 */
@TableName(value ="product_info")
@Data
public class StockInfo implements Serializable {
    /**
     * 产品id
     */
    @TableId(type = IdType.AUTO)
    private Long productId;

    /**
     * 产品名称
     */
    private String productName;

    /**
     * 产品创建时间
     */
    private Date productCreateTime;

    /**
     * 产品状态{0：下架状态；1：上架状态}
     */
    private Integer productStatus;

    /**
     * 产品库存
     */
    private Integer productRepertories;

    /**
     * 通用模式下权限级别最低不低于此字段值
     */
    private Integer productCommonLevel;

    /**
     * 产品类型（0：通用；1：特殊）{
匹配查看产品模式，
0：表示只需要满足权限级别大于等于common_level即可查看；
1：表示只有当权限级别等于产品级别才可被查看
}
     */
    private Integer productType;

    /**
     * 特殊模式下权限级别只能等于此级别
     */
    private Integer productSpecLevel;

    /**
     * 更新时间
     */
    private Date productModifiedTime;

    /**
     * 删除标志位（0：未删除，1：已删除）
     */
    private Integer productIsDel;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}