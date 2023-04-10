package os.g.zone.orders.controller;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import os.g.zone.commons.consts.ReplyCode;
import os.g.zone.commons.results.JsonPage;
import os.g.zone.commons.results.JsonResult;
import os.g.zone.orders.pojo.dto.OrderInfoDTO;
import os.g.zone.orders.pojo.vo.OrderInfoVO;
import os.g.zone.orders.service.IOrderInfoService;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * 订单控制器
 * @Auther: AA
 * @Date: 2023/3/29 15:46
 * @Version 1.0.0
 */
@RestController
@Slf4j
public class OrdersController {
    @Autowired
    private IOrderInfoService iOrderInfoService;

    @PostMapping("/save")
    public JsonResult<Void> saveProduct(OrderInfoVO orderInfoVO){
        OrderInfoDTO param = new OrderInfoDTO();
        BeanUtils.copyProperties(orderInfoVO,param);
        Date now = new Date(System.currentTimeMillis());
        param.setOrderCreateTime(now);
        int res = iOrderInfoService.insertOrder(param);
        if(res != 1){
            return JsonResult.failed(ReplyCode.RES_ERROR,"新增订单失败！");
        }
        return JsonResult.success();
    }

    @PostMapping("/update")
    public JsonResult<Void> updateProduct(OrderInfoVO orderInfoVO){
        OrderInfoDTO param = new OrderInfoDTO();
        BeanUtils.copyProperties(orderInfoVO,param);
        Date now = new Date(System.currentTimeMillis());
        param.setOrderModifiedTime(now);
        int res = iOrderInfoService.updateOrderById(param);
        if(res != 1){
            return JsonResult.failed(ReplyCode.RES_ERROR,"修改订单失败！");
        }
        return JsonResult.success();
    }

    @GetMapping("/query/{pageIndex}/{pageSize}")
    public JsonResult getAllProduct(
            @PathVariable("pageIndex") Long pageIndex,
            @PathVariable("pageSize") Long pageSize, OrderInfoVO order){
        log.debug("请求参数为：【{},{},{}】",pageIndex,pageSize,order);
        OrderInfoDTO orderInfoDTO = new OrderInfoDTO();
        BeanUtils.copyProperties(order,orderInfoDTO);
        JsonPage<OrderInfoDTO> data = iOrderInfoService.listOrderByPage(
                pageIndex,pageSize,orderInfoDTO);

        return JsonResult.success(data);
    }
}
