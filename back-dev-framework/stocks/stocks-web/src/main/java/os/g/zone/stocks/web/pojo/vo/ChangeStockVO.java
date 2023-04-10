package os.g.zone.stocks.web.pojo.vo;

import lombok.Data;

/**
 * @Auther: AA
 * @Date: 2023/4/5 23:38
 * @Description: ChangeStockVO
 * @Version 1.0.0
 */
@Data
public class ChangeStockVO {
    // 产品id
    private Long productId;
    // 减少库存数
    private Integer reduceCount;
}
