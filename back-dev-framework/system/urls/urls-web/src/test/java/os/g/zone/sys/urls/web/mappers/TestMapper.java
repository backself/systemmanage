package os.g.zone.sys.urls.web.mappers;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import os.g.zone.sys.urls.web.pojo.bo.SystemUrlBO;
import os.g.zone.sys.urls.web.pojo.po.SystemUrlPO;

/**
 * @Auther: AA
 * @Date: 2023/4/7 11:27
 * @Description: TestMapper
 * @Version 1.0.0
 */
@SpringBootTest
@Slf4j
public class TestMapper {
    @Autowired
    private SystemUrlMapper systemUrlMapper;

    @Test
    public void testA(){
        SystemUrlPO systemUrlPO = new SystemUrlPO();
        systemUrlMapper.getMenuTree(systemUrlPO).forEach((item)->{
                log.debug(item.toString());
        });
    }
}
