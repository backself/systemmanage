package os.g.zone.sys.users.api.service;

import os.g.zone.commons.results.JsonPage;
import os.g.zone.sys.users.api.dto.SystemUserDTO;
import os.g.zone.sys.users.api.dto.SystemUserLoginInfoDTO;

import java.util.List;

/**
* @author AA
* @description 针对表【system_user(用户表，保存用户信息)】的数据库操作Service
* @createDate 2023-04-03 11:00:58
*/
public interface ISystemUserService {

    int insertSystemUser(SystemUserDTO systemUserDTO);
    int updateSystemUserById(SystemUserDTO systemUserDTO);
    int deleteSystemUserByIds(List<Long> ids);

    JsonPage<SystemUserDTO> listAllSystemUserByPage(Integer pageIndex,Integer pageSize,String keywords);
    SystemUserLoginInfoDTO getLoginInfoByUsername(String userName);

}
