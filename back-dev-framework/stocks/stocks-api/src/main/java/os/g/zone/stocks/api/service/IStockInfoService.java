package os.g.zone.stocks.api.service;

import os.g.zone.stocks.api.dto.ChangeStockDTO;
import os.g.zone.stocks.api.dto.UpdateStockDTO;

/**
* @author AA
* @description 针对表【product_info(产品信息表)】的数据库操作Service
* @createDate 2023-04-05 22:44:47
*/
public interface IStockInfoService {
    /**
     * 使用增加或者减少的方式修改库存
     * @Auther: AA
     * @Date: 2023/4/6 0:06
     * @Version 1.0.0
     */
    int changeProductStockById(ChangeStockDTO changeStockDTO);
    /**
     * 重新设定库存
     * @Auther: AA
     * @Date: 2023/4/6 0:06
     * @Version 1.0.0
     */
    int updateProductStockById(UpdateStockDTO updateStockDTO);
}
