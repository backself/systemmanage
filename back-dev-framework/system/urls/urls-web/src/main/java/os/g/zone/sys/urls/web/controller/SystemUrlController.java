package os.g.zone.sys.urls.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import os.g.zone.commons.consts.ReplyCode;
import os.g.zone.commons.results.JsonPage;
import os.g.zone.commons.results.JsonResult;
import os.g.zone.sys.urls.api.dto.SystemUrlDTO;
import os.g.zone.sys.urls.api.dto.TreeMenuDTO;
import os.g.zone.sys.urls.web.pojo.vo.SystemUrlVO;
import os.g.zone.sys.urls.api.service.ISystemUrlService;

import java.util.List;

/**
 * 产品服务控制器
 * @Auther: AA
 * @Date: 2023/3/29 15:46
 * @Version 1.0.0
 */
@RestController
@Slf4j
@Transactional
public class SystemUrlController {
    @Autowired
    private ISystemUrlService iSystemUrlService;

    @RequestMapping("/save")
    public JsonResult<Void> saveUrl(SystemUrlVO systemUrlVO){
        SystemUrlDTO param = new SystemUrlDTO();
        BeanUtils.copyProperties(systemUrlVO,param);
        int res = iSystemUrlService.insertSystemUrl(param);
        if(res != 1){
            return JsonResult.failed(ReplyCode.RES_ERROR,"新增链接失败！");
        }
        return JsonResult.success();
    }

    @RequestMapping("/update")
    public JsonResult<Void> updateUrl(SystemUrlVO systemUrlVO){
        SystemUrlDTO param = new SystemUrlDTO();
        BeanUtils.copyProperties(systemUrlVO,param);
        int res = iSystemUrlService.updateSystemUrlById(param);
        if(res != 1){
            return JsonResult.failed(ReplyCode.RES_ERROR,"修改链接失败！");
        }
        return JsonResult.success();
    }

    @RequestMapping("/all/list")
    public JsonResult getAllProduct(){
        SystemUrlDTO systemUrlDTO = new SystemUrlDTO();
        List<SystemUrlDTO> data = iSystemUrlService.listSystemUrls(
                systemUrlDTO);
        return JsonResult.success(data);
    }

    @RequestMapping("/nav/list")
    public JsonResult getAllNavList(){
        List<TreeMenuDTO> data = iSystemUrlService.listSystemNavUrl();
        return JsonResult.success(data);
    }
}
