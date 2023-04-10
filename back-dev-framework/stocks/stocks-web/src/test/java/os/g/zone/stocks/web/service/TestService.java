package os.g.zone.stocks.web.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import os.g.zone.stocks.api.dto.ChangeStockDTO;
import os.g.zone.stocks.api.service.IStockInfoService;
import os.g.zone.stocks.api.consts.OperatorStockEnum;

/**
 * @Auther: AA
 * @Date: 2023/4/5 23:10
 * @Description: TestService
 * @Version 1.0.0
 */
@SpringBootTest
@Slf4j
public class TestService {
    @Autowired
    private IStockInfoService iStockInfoService;
    @Test
    public void testSer(){
        ChangeStockDTO changeStockDTO = new ChangeStockDTO();
        changeStockDTO.setProductId(1L);
        changeStockDTO.setChangeType(OperatorStockEnum.REDUCE.getType());
        changeStockDTO.setCount(2);
        int res = iStockInfoService.changeProductStockById(changeStockDTO);
        log.debug("res:[{}]",res);
    }
}
