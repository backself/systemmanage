package os.g.zone.sys.users.web.controller;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import os.g.zone.commons.consts.ReplyCode;
import os.g.zone.commons.results.JsonPage;
import os.g.zone.commons.results.JsonResult;
import os.g.zone.sys.users.api.dto.SystemUserDTO;
import os.g.zone.sys.users.web.pojo.vo.SystemUserVO;
import os.g.zone.sys.users.api.service.ISystemUserService;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: AA
 * @Date: 2023/4/3 11:32
 * @Description: UsersController
 * @Version 1.0.0
 */
@RestController
@Slf4j
@Transactional
public class UsersController {

    @DubboReference
    private ISystemUserService iSystemUserService;

    @PostMapping("/save")
    public JsonResult<Void> saveUser(SystemUserVO systemUserVO){
        SystemUserDTO param = new SystemUserDTO();
        BeanUtils.copyProperties(systemUserVO,param);
        param.setUserCreateTime(new Timestamp(System.currentTimeMillis()));
        int res = iSystemUserService.insertSystemUser(param);
        if(res != 1){
            return JsonResult.failed(ReplyCode.RES_ERROR,"新增用户失败！");
        }
        return JsonResult.success();
    }

    @PostMapping("/update")
    public JsonResult<Void> updateUser(SystemUserVO systemUserVO){
        SystemUserDTO param = new SystemUserDTO();
        BeanUtils.copyProperties(systemUserVO,param);
        param.setUserModifiedTime(new Timestamp(System.currentTimeMillis()));
        int res = iSystemUserService.updateSystemUserById(param);
        if(res != 1){
            return JsonResult.failed(ReplyCode.RES_ERROR,"修改用户失败！");
        }
        return JsonResult.success();
    }

    @PostMapping("/del")
    public JsonResult<Void> delBatchUsers(String ids){
        log.debug(ids);
        String[] params = ids.split(",");
        List<Long> longList = new ArrayList<>();
        for (int i = 0; i < params.length; i++) {
            longList.add(Long.valueOf(params[i]));
        }
        iSystemUserService.deleteSystemUserByIds(longList);
        return JsonResult.success();
    }

    @GetMapping("/list/{pageIndex}/{pageSize}")
    public JsonResult getAllUser(
            @PathVariable("pageIndex") Integer pageIndex,
            @PathVariable("pageSize") Integer pageSize, @RequestBody String keywords){
        JSONObject jsonObject = JSONObject.parseObject(keywords);
        String params = String.valueOf(jsonObject.get("keywords"));
        JsonPage<SystemUserDTO> data = iSystemUserService.listAllSystemUserByPage(
                pageIndex,pageSize,params);

        return JsonResult.success(data);
    }

}
