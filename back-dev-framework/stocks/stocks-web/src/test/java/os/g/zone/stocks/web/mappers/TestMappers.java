package os.g.zone.stocks.web.mappers;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import os.g.zone.stocks.web.pojo.entitys.StockInfo;
import os.g.zone.stocks.web.pojo.po.ChangeStockPO;

/**
 * @Auther: AA
 * @Date: 2023/4/5 22:50
 * @Description: TestMappers
 * @Version 1.0.0
 */
@SpringBootTest
@Slf4j
public class TestMappers {

    @Autowired
    private StockInfoMapper stockInfoMapper;
    @Test
    public void testProducts(){
        StockInfo stockInfo = stockInfoMapper.selectById(1);
        log.debug("{}", stockInfo);
    }
    @Test
    public void testReProducts(){
        ChangeStockPO changeStockPO = new ChangeStockPO();
        changeStockPO.setProductId(1L);
        changeStockPO.setCount(2);
        int res = stockInfoMapper.changeProductStockById(changeStockPO);
        log.debug("res:[{}]",res);
    }
}
