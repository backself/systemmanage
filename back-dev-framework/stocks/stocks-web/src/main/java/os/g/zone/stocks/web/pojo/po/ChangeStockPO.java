package os.g.zone.stocks.web.pojo.po;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 产品库存实体
 * @TableName product_info
 */
@Data
public class ChangeStockPO implements Serializable {
    /**
     * 产品id
     */
    private Long productId;
    /**
     * 修改方式
     * @Auther: AA
     * @Date: 2023/4/5 23:46
     * @Version 1.0.0
     */
    private Integer changeType;

    /**
     * 产品库存
     */
    private Integer count;

    /**
     * 更新时间
     */
    private Date productModifiedTime;

}