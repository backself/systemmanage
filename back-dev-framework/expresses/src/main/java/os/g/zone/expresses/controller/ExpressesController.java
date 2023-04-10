package os.g.zone.expresses.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import os.g.zone.commons.results.JsonResult;
import os.g.zone.expresses.pojo.dto.ExpressesDetailInfoDTO;
import os.g.zone.expresses.pojo.dto.ExpressesInfoDTO;
import os.g.zone.expresses.pojo.vo.ExpressesInfoVO;
import os.g.zone.expresses.service.ExpressesInfoService;

/**
 * @Auther: AA
 * @Date: 2023/4/3 20:39
 * @Description: ExpressesController
 * @Version 1.0.0
 */
@RestController
public class ExpressesController {
    @Autowired
    private ExpressesInfoService expressesInfoService;
    @RequestMapping("/get")
    public JsonResult getExpressesInfo(ExpressesInfoVO expressesInfoVO){
        ExpressesInfoDTO expressesInfoDTO = new ExpressesInfoDTO();
        BeanUtils.copyProperties(expressesInfoVO,expressesInfoDTO);
        ExpressesDetailInfoDTO expressesDetailInfoDTO = expressesInfoService.listExpressesInfoById(expressesInfoDTO);
        expressesDetailInfoDTO.setExpressesName("韵达");
        expressesDetailInfoDTO.setExpressesCurrentNodeName("重庆市九龙坡韵达物流中心");
        expressesDetailInfoDTO.setExpressesContactNumber("1111-1111111");
        expressesDetailInfoDTO.setExpressesContactName("快递小哥A");
        return JsonResult.success(expressesDetailInfoDTO);
    }

    @RequestMapping("/update")
    public JsonResult updateExpressesInfo(ExpressesInfoVO expressesInfoVO){
        ExpressesInfoDTO expressesInfoDTO = new ExpressesInfoDTO();
        BeanUtils.copyProperties(expressesInfoVO,expressesInfoDTO);
        int res = expressesInfoService.appendExpressesInfo(expressesInfoDTO);
        return JsonResult.success("更新物流信息成功");
    }

}
