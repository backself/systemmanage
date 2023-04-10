package os.g.zone.sys.roles.web.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import os.g.zone.sys.roles.api.dto.CorrelationsRoleAndUrlDTO;
import os.g.zone.sys.roles.api.dto.SystemRoleUrlTempDTO;
import os.g.zone.sys.roles.api.service.SystemRoleUrlTempService;
import os.g.zone.sys.roles.web.mappers.SystemRoleUrlTempMapper;
import os.g.zone.sys.roles.web.pojo.bo.SystemRoleUrlTempBO;
import os.g.zone.sys.roles.web.pojo.entitys.SystemRoleUrlTemp;

import java.util.ArrayList;
import java.util.List;

/**
* @author 83416
* @description 针对表【system_role_url_temp(权限链接对应关系表

当权限或者链接匹配模式修改时：
将该权限或者链接原持有的所有链接记录全部设置为失效；

详细描述如下：
当修改权限匹配模式为通用模式时
权限级别修改后需要将该权限原持有的匹配模式为精准模式的所有链接记录全部设置为失效

当修改权限匹配模式为精准模式时
权限级别修改后需要将该权限原持有的匹配模式为通用模式的所有链接记录全部设置为失效


当级别发生改变时：

当链接级别发生改变时：
链接如果为通用模式匹配下则不产生影响；
链接如果为对精准模式匹配则将原有的记录更新为失效，保存原因在每条记录的temp_reason字段，并排除掉已失效的记录
并将新的权限链接关系记录到此表中

当权限级别发生改变时
权限的匹配模式如果为通用模式匹配下则不产生影响；
权限的匹配模式如果为对精准模式匹配则将原有的记录更新为失效，保存原因在每条记录的temp_reason字段，并排除掉已失效的记录
并将新的权限链接关系记录到此表中)】的数据库操作Service实现
* @createDate 2023-04-09 22:03:48
*/
@Service
public class SystemRoleUrlTempServiceImpl implements SystemRoleUrlTempService {
    @Autowired
    private SystemRoleUrlTempMapper systemRoleUrlTempMapper;


    @Override
    public List<SystemRoleUrlTempDTO> listSystemUrlAndRoleById(Long id) {
        List<SystemRoleUrlTempBO> list = systemRoleUrlTempMapper.selectUrlRoleById(id);
        List<SystemRoleUrlTempDTO> res = new ArrayList<>();
        SystemRoleUrlTempDTO itemDTO = new SystemRoleUrlTempDTO();
        for(SystemRoleUrlTempBO item:list){
            BeanUtils.copyProperties(item,itemDTO);
            res.add(itemDTO);
        }
        return res;
    }

    @Override
    public void updateSystemUrlsAndRoles(CorrelationsRoleAndUrlDTO correlationsRoleAndUrlDTO){
        QueryWrapper<SystemRoleUrlTemp> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("role_id",correlationsRoleAndUrlDTO.getRoleId());
        systemRoleUrlTempMapper.delete(queryWrapper);
        List<SystemRoleUrlTemp> roleAndUrlIds = new ArrayList<>();
       for (int i = 0 ;i< correlationsRoleAndUrlDTO.getUrlIds().size();i++){
           SystemRoleUrlTemp item = new SystemRoleUrlTemp();
           item.setRoleId(correlationsRoleAndUrlDTO.getRoleId());
           item.setUrlId(correlationsRoleAndUrlDTO.getUrlIds().get(i));
           roleAndUrlIds.add(item);
       }
        systemRoleUrlTempMapper.insertBatch(roleAndUrlIds);
    }
}




