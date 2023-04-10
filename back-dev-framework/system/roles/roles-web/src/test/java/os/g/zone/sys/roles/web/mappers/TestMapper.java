package os.g.zone.sys.roles.web.mappers;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import os.g.zone.sys.roles.web.pojo.bo.SystemRoleUrlTempBO;

import java.util.List;

@SpringBootTest
@Slf4j
public class TestMapper {
    @Autowired
    private SystemRoleUrlTempMapper systemRoleUrlTempMapper;
    @Test
    public void test(){

        List<SystemRoleUrlTempBO> systemRoleUrlTempBOS = systemRoleUrlTempMapper.selectUrlRoleById(0L);
        log.debug(systemRoleUrlTempBOS.toString());

    }
}
