package os.g.zone.stocks.api.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 库存数据层传递实体
 * @Auther: AA
 * @Date: 2023/4/5 22:59
 * @Description: ChangeStockDTO
 * @Version 1.0.0
 */
@Data
public class ChangeStockDTO implements Serializable {

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

}
