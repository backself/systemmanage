package os.g.zone.sys.users.web;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import os.g.zone.commons.exceptions.ServiceException;
import os.g.zone.sys.users.api.dto.SystemUserDTO;
import os.g.zone.sys.users.api.service.ISystemUserService;

@SpringBootTest
@Slf4j
public class iUserService {
    @Autowired
    private ISystemUserService systemUserService;

    @Test
    void insertSystemUser(){
        SystemUserDTO systemUserDTO = new SystemUserDTO();
        systemUserDTO.setUserId(13L);
        systemUserDTO.setUserName("张三");
        systemUserDTO.setNickName("三");
        systemUserDTO.setUserPassword("123");
        try {
            systemUserService.insertSystemUser(systemUserDTO);
            log.info("添加用户成功");
        }catch (ServiceException e){
            log.debug("捕获到异常，其中的消息：{}", e.getMessage());
        }
    }

}
