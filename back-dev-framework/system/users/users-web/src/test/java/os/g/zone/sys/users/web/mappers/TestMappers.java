package os.g.zone.sys.users.web.mappers;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import os.g.zone.sys.users.web.pojo.bo.SystemUserLoginInfoBO;

@SpringBootTest
@Slf4j
public class TestMappers {
    @Autowired
    private SystemUserMapper systemUserMapper;
    @Test
    void insertSystemUser(){
        SystemUserLoginInfoBO AA = systemUserMapper.getLoginInfoByUsername("郝岚");
        log.debug(AA.toString());
    }
}
