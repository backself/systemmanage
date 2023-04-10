package os.g.zone.sys.roles.web.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import os.g.zone.sys.roles.web.mappers.SystemRoleMapper;
import os.g.zone.sys.roles.api.dto.SystemRoleDTO;
import os.g.zone.sys.roles.web.pojo.entitys.SystemRole;
import os.g.zone.sys.roles.api.service.ISystemRoleService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
* @author AA
* @description 针对表【system_role(权限表，对应用户角色
当权限的匹配模式由通用模式修改为精准模式时，保留父级权限id，用于未来修改子级权限
当权限的匹配模式由精准模式修改为通用模式时，必须将当前权限级别修改为小于等与父级权限级别)】的数据库操作Service实现
* @createDate 2023-04-03 10:18:33
*/
@Service
@DubboService
public class SystemRoleServiceImpl implements ISystemRoleService {

    @Autowired
    private SystemRoleMapper systemRoleMapper;

    @Override
    public int updateSystemRoleById(SystemRoleDTO systemRoleDTO) {
        SystemRole systemRole = new SystemRole();
        BeanUtils.copyProperties(systemRoleDTO,systemRole);
        int i = systemRoleMapper.updateById(systemRole);
        return i;
    }

    @Override
    public int insertSystemRole(SystemRoleDTO systemRoleDTO) {
        SystemRole systemRole = new SystemRole();
        BeanUtils.copyProperties(systemRoleDTO,systemRole);
        int i = systemRoleMapper.insert(systemRole);
        return i;
    }

    @Override
    public List<SystemRoleDTO> listSystemRole(SystemRoleDTO systemRoleDTO) {
        QueryWrapper<SystemRole> queryWrapper = new QueryWrapper<>();
        List<SystemRole> list = systemRoleMapper.selectList(queryWrapper);
        List<SystemRoleDTO> res = new ArrayList<>();
        for (SystemRole role:list) {
            SystemRoleDTO temp = new SystemRoleDTO();
            BeanUtils.copyProperties(role,temp);
            res.add(temp);
        }
        return res;
    }

}




