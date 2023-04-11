package os.g.zone.orders.quartz;

import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import os.g.zone.orders.pojo.dto.OrderInfoDTO;
import os.g.zone.orders.service.IOrderInfoService;
import os.g.zone.orders.service.impl.OrderInfoServiceImpl;

import java.sql.Date;

/**
 * @Auther: AA
 * @Date: 2023/4/9 09:14
 * @Description: AddOrdersJob
 * @Version 1.0.0
 */
@Slf4j
public class AddOrdersJob implements Job {
    @Autowired
    private IOrderInfoService iOrderInfoService;
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        OrderInfoDTO param = new OrderInfoDTO();
        param.setConsumerId(1L);
        param.setProductId(1L);
        Date now = new Date(System.currentTimeMillis());
        param.setOrderCreateTime(now);
        int res = iOrderInfoService.insertOrder(param);
        log.debug("定时增加订单：【{}】",param);
    }
}
