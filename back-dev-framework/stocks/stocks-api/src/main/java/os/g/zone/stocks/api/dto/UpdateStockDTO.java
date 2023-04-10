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
public class UpdateStockDTO implements Serializable {

    private Long productId;
    /**
     * 产品库存
     */
    private Integer count;

}
