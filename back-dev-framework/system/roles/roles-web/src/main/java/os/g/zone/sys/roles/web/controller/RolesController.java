package os.g.zone.sys.roles.web.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import os.g.zone.commons.consts.ReplyCode;
import os.g.zone.commons.results.JsonResult;
import os.g.zone.sys.roles.api.dto.SystemRoleDTO;
import os.g.zone.sys.roles.web.pojo.vo.SystemRoleVO;
import os.g.zone.sys.roles.api.service.ISystemRoleService;

import java.sql.Timestamp;
import java.util.List;

/**
 * 角色表控制器
 * @Auther: AA
 * @Date: 2023/3/29 15:46
 * @Version 1.0.0
 */
@RestController
@Transactional
public class RolesController {
    @Autowired
    private ISystemRoleService iSystemRoleService;

    @PostMapping("/save")
    public JsonResult<Void> saveProduct(SystemRoleVO systemRoleVO){
        SystemRoleDTO param = new SystemRoleDTO();
        BeanUtils.copyProperties(systemRoleVO,param);
        param.setRoleCreateTime(new Timestamp(System.currentTimeMillis()));
        int res = iSystemRoleService.insertSystemRole(param);
        if(res != 1){
            return JsonResult.failed(ReplyCode.RES_ERROR,"新增角色失败！");
        }
        return JsonResult.success();
    }

    @PostMapping("/update")
    public JsonResult<Void> updateProduct(SystemRoleVO systemRoleVO){
        SystemRoleDTO param = new SystemRoleDTO();
        BeanUtils.copyProperties(systemRoleVO,param);
        param.setRoleModifiedTime(new Timestamp(System.currentTimeMillis()));
        int res = iSystemRoleService.updateSystemRoleById(param);
        if(res != 1){
            return JsonResult.failed(ReplyCode.RES_ERROR,"修改角色失败！");
        }
        return JsonResult.success();
    }

    @GetMapping("/list")
    public JsonResult getAllProduct( @RequestBody String keywords){
        JSONObject jsonObject = JSONObject.parseObject(keywords);
        String params = String.valueOf(jsonObject.get("keywords"));
        SystemRoleDTO systemRoleDTO = new SystemRoleDTO();
        systemRoleDTO.setRoleName(params);
        List<SystemRoleDTO> data = iSystemRoleService.listSystemRole(systemRoleDTO);

        return JsonResult.success(data);
    }
}
