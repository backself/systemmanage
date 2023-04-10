package os.g.zone.sys.users.web.mappers;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import os.g.zone.sys.users.web.pojo.bo.SystemUserLoginInfoBO;
import os.g.zone.sys.users.web.pojo.po.SystemUserPO;
import os.g.zone.sys.users.web.pojo.bo.SystemUserBO;
import os.g.zone.sys.users.web.pojo.entitys.SystemUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author AA
* @description 针对表【system_user(用户表，保存用户信息)】的数据库操作Mapper
* @createDate 2023-04-03 11:00:58
* @Entity entitys.pojo.os.g.zone.sys.users.SystemUser
*/
public interface SystemUserMapper extends BaseMapper<SystemUser> {
    Page<SystemUserBO> listAllSystemUserByPage(@Param("page")Page<SystemUserBO> page,@Param("systemUserPO") SystemUserPO systemUserPO);

    int countByName(String name);

    /**
     * 根据用户名查询管理员的登录信息
     * @param username 用户名
     * @return 匹配的管理员的登录信息，如果没有匹配的数据，则返回null
     */
    SystemUserLoginInfoBO getLoginInfoByUsername(String username);
}




