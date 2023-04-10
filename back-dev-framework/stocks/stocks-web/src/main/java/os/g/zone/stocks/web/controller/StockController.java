package os.g.zone.stocks.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import os.g.zone.commons.consts.ReplyCode;
import os.g.zone.commons.results.JsonResult;
import os.g.zone.stocks.api.dto.ChangeStockDTO;
import os.g.zone.stocks.api.dto.UpdateStockDTO;
import os.g.zone.stocks.api.service.IStockInfoService;
import os.g.zone.stocks.api.consts.OperatorStockEnum;
import os.g.zone.stocks.web.pojo.vo.ChangeStockVO;

/**
 * @Auther: AA
 * @Date: 2023/4/5 23:36
 * @Description: StockController
 * @Version 1.0.0
 */
@RestController
public class StockController {

    @Autowired
    private IStockInfoService iStockInfoService;
    @RequestMapping("/change/{type}")
    public JsonResult reduceStock(@PathVariable("type") Integer type, ChangeStockVO changeStockVO){
        JsonResult jsonResult = JsonResult.failed(ReplyCode.RES_ERROR,"操作失败");
        ChangeStockDTO changeStockDTO = new ChangeStockDTO();
        if (OperatorStockEnum.REDUCE.getType().equals(type)){
            changeStockDTO.setChangeType(OperatorStockEnum.REDUCE.getType());
            jsonResult = JsonResult.success("减库存成功");
        }
        if (OperatorStockEnum.PLUS.getType().equals(type)){
            changeStockDTO.setChangeType(OperatorStockEnum.PLUS.getType());
            jsonResult = JsonResult.success("加库存成功");
        }
        iStockInfoService.changeProductStockById(changeStockDTO);
        return jsonResult;
    }
    @RequestMapping("/update/")
    public JsonResult reduceStock(ChangeStockVO changeStockVO){
        JsonResult jsonResult = JsonResult.failed(ReplyCode.RES_ERROR,"更新失败");
        UpdateStockDTO updateStockDTO = new UpdateStockDTO();
        updateStockDTO.setProductId(changeStockVO.getProductId());
        updateStockDTO.setCount(changeStockVO.getReduceCount());
        iStockInfoService.updateProductStockById(updateStockDTO);
        jsonResult = JsonResult.success();
        return jsonResult;
    }

}
