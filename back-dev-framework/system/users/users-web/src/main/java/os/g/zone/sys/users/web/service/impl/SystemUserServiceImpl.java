package os.g.zone.sys.users.web.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import os.g.zone.commons.consts.ReplyCode;
import os.g.zone.commons.exceptions.ServiceException;
import os.g.zone.commons.results.JsonPage;
import os.g.zone.sys.users.api.dto.SystemUserLoginInfoDTO;
import os.g.zone.sys.users.web.mappers.SystemUserMapper;
import os.g.zone.sys.users.api.dto.SystemUserDTO;
import os.g.zone.sys.users.api.service.ISystemUserService;
import os.g.zone.sys.users.web.pojo.bo.SystemUserLoginInfoBO;
import os.g.zone.sys.users.web.pojo.entitys.SystemUser;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
* @author AA
* @description 针对表【system_user(用户表，保存用户信息)】的数据库操作Service实现
* @createDate 2023-04-03 11:00:58
*/
@Service
@Slf4j
@DubboService
public class SystemUserServiceImpl implements ISystemUserService {
    @Autowired
    private SystemUserMapper systemUserMapper;

    @Override
    public int insertSystemUser(SystemUserDTO systemUserDTO) {
        String name = systemUserDTO.getUserName();
        int count = systemUserMapper.countByName(name);
        if (count>0){
            String message = "添加用户失败，用户名称已被占用！";
            log.warn(message);
            throw new ServiceException(ReplyCode.RES_ERROR,message);
        }
        SystemUser systemUser = new SystemUser();
        BeanUtils.copyProperties(systemUserDTO,systemUser);
        log.debug("原数据【{}】：",systemUserDTO);
        log.debug("执行插入转换后的数据：【{}】",systemUser);
        return systemUserMapper.insert(systemUser);
    }
    @Override
    public int deleteSystemUserByIds(List<Long> ids) {
        SystemUser systemUser = new SystemUser();
        systemUser.setUserIsDel(1);
        QueryWrapper<SystemUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("user_id",ids);
        int res = systemUserMapper.update(systemUser,queryWrapper);
        return res;
    }

    @Override
    public int updateSystemUserById(SystemUserDTO systemUserDTO) {
        int count = systemUserMapper.countByName(systemUserDTO.getUserName());
        if (count>1){
            String message = "修改用户失败，用户名称已被占用！";
            log.warn(message);
            throw new ServiceException(ReplyCode.RES_ERROR,message);
        }
        SystemUser systemUser = new SystemUser();
        BeanUtils.copyProperties(systemUserDTO,systemUser);
        log.debug("原数据【{}】：",systemUserDTO);
        log.debug("执行将新数据：【{}】更新",systemUser);
        return systemUserMapper.updateById(systemUser);
    }



    @Override
    public JsonPage<SystemUserDTO> listAllSystemUserByPage(Integer pageIndex,Integer pageSize,String keywords) {
        // page对象中的泛型使用的是接收结果用的对象
        Page<SystemUser> page = new Page<>(pageIndex,pageSize);
        QueryWrapper<SystemUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("nick_name",keywords);
        systemUserMapper.selectPage(page,queryWrapper);
        log.debug("===================页面信息数据=========================");
        log.debug("数据库分页查询记录总数：【{}】",page.getTotal());
        log.debug("数据库分页查询当前页下标：【{}】",page.getCurrent());
        log.debug("数据库分页查询当前页记录数：【{}】",page.getSize());
        log.debug("数据库分页查询总页数：【{}】",page.getPages());
        log.debug("====================页面记录========================");
        log.debug("数据库分页查询结果：【{}】",page.getRecords());
        JsonPage jsonPage = JsonPage.parse(page);
        return jsonPage;
    }

    @Override
    public SystemUserLoginInfoDTO getLoginInfoByUsername(String userName) {
        SystemUserLoginInfoBO systemUserLoginInfoBO = systemUserMapper.getLoginInfoByUsername(userName);
        List<String> perssions = new ArrayList<>();
        systemUserLoginInfoBO.getPermissions().forEach((per)->{
            perssions.add((String) per.get("roleName"));
        });
        SystemUserLoginInfoDTO systemUserLoginInfoDTO = new SystemUserLoginInfoDTO();
        BeanUtils.copyProperties(systemUserLoginInfoBO,systemUserLoginInfoDTO);
        systemUserLoginInfoDTO.setPermissions(perssions);
        return systemUserLoginInfoDTO;
    }


}




