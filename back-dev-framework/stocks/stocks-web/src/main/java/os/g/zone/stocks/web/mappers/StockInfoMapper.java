package os.g.zone.stocks.web.mappers;

import os.g.zone.stocks.web.pojo.entitys.StockInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import os.g.zone.stocks.web.pojo.po.ChangeStockPO;

/**
* @author AA
* @description 针对表【product_info(产品信息表)】的数据库操作Mapper
* @createDate 2023-04-05 22:44:47
* @Entity os.g.zone.stocks.web.pojo.entitys.StockInfo
*/
public interface StockInfoMapper extends BaseMapper<StockInfo> {
    int changeProductStockById(ChangeStockPO changeStockPO);
}




