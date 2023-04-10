package os.g.zone.sys.roles.web.mappers;

import os.g.zone.sys.roles.web.pojo.entitys.SystemRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author AA
* @description 针对表【system_role(权限表，对应用户角色
当权限的匹配模式由通用模式修改为精准模式时，保留父级权限id，用于未来修改子级权限
当权限的匹配模式由精准模式修改为通用模式时，必须将当前权限级别修改为小于等与父级权限级别)】的数据库操作Mapper
* @createDate 2023-04-03 10:18:33
* @Entity entitys.pojo.os.g.zone.sys.roles.SystemRole
*/
public interface SystemRoleMapper extends BaseMapper<SystemRole> {



}




