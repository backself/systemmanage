package os.g.zone.pay.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import os.g.zone.pay.util.PayResult;
import os.g.zone.pay.util.ReplyCode;

/**
 * 模拟支付 场景
 * @Auther: AA
 * @Date: 2023/3/30 10:09
 * @Description: PayController
 * @Version 1.0.0
 */
@RestController
public class PayController {
    /**
     * 支付模拟参数
     * @param type "支付类型（1：成功，0：失败）"
     * @Auther: AA
     * @Date: 2023/3/30 10:16
     * @Version 1.0.0
     */
    @RequestMapping("type/{type}")
    public PayResult pay(@PathVariable("type") Integer type){
        if(type == 1){
            return PayResult.success("支付成功!");
        }
        return PayResult.failed(ReplyCode.RES_ERROR,"支付失败!");
    }

    /**
     * 取消支付以及退款操作 模拟参数
     * @param type "支付类型（1：成功，0：失败）"
     * @Auther: AA
     * @Date: 2023/3/30 10:16
     * @Version 1.0.0
     */
    @RequestMapping("/drawback/{type}")
    public PayResult drawback(@PathVariable("type") Integer type){
        if(type == 1){
            return PayResult.success("退款成功!");
        }
        return PayResult.failed(ReplyCode.RES_ERROR,"退款失败!");
    }

}
