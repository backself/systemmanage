package os.g.zone.sso.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import os.g.zone.commons.results.JsonResult;
import os.g.zone.sso.pojo.dto.SystemUserLoginParamsDTO;
import os.g.zone.sso.service.impl.SSOLoginService;

@RestController
@RequestMapping("/users")
@Slf4j
public class SSOController {
    @Autowired
    private SSOLoginService ssoLoginService;

    @PostMapping("/login")
    public JsonResult<Void> login(SystemUserLoginParamsDTO systemUserLoginParamsDTO) {
        log.debug("开始处理【管理员登录】的请求，参数：{}", systemUserLoginParamsDTO);
        ssoLoginService.login(systemUserLoginParamsDTO);
        return JsonResult.success();
    }
}
