package os.g.zone.sys.roles.web.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import os.g.zone.commons.results.JsonResult;
import os.g.zone.sys.roles.api.dto.CorrelationsRoleAndUrlDTO;
import os.g.zone.sys.roles.api.dto.SystemRoleDTO;
import os.g.zone.sys.roles.api.dto.SystemRoleUrlTempDTO;
import os.g.zone.sys.roles.api.service.SystemRoleUrlTempService;
import os.g.zone.sys.roles.web.pojo.vo.CorrelationsRoleAndUrlVO;

import java.util.List;

/**
 * 角色菜单控制器
 */
@RestController
@Transactional
public class RoleUrlTempController {
    @Autowired
    private SystemRoleUrlTempService systemRoleUrlTempService;



    @GetMapping("/panel/list")
    public JsonResult getAllProduct(Long roleId){

        List<SystemRoleUrlTempDTO> data = systemRoleUrlTempService.listSystemUrlAndRoleById(roleId);

        return JsonResult.success(data);
    }

    @GetMapping("/correlations/urls/update")
    public JsonResult getAllProduct(CorrelationsRoleAndUrlVO vo){
        CorrelationsRoleAndUrlDTO correlationsRoleAndUrlDTO = new CorrelationsRoleAndUrlDTO();
        BeanUtils.copyProperties(vo,correlationsRoleAndUrlDTO);
        systemRoleUrlTempService.updateSystemUrlsAndRoles(correlationsRoleAndUrlDTO);
        return JsonResult.success();
    }
}
