package os.g.zone.orders.service;

import os.g.zone.commons.results.JsonPage;
import os.g.zone.orders.pojo.dto.OrderInfoDTO;

import java.util.List;

/**
* @author AA
* @description 针对表【order_info(订单信息表)】的数据库操作Service
* @createDate 2023-03-29 23:57:30
*/
public interface IOrderInfoService {

    int insertOrder(OrderInfoDTO orderInfoDTO);
    int insertBatchOrder(List<OrderInfoDTO> orderInfoDTOS);
    int removeOrderById(Long pId);
    int removeBatchOrderByIds(List<Long> oIds);
    int updateOrderById(OrderInfoDTO orderInfoDTO);
    OrderInfoDTO getOrderById(Long oId);
    JsonPage<OrderInfoDTO> listOrderByPage(Long pageIndex, Long pageSize, OrderInfoDTO orderInfoDTO);
}
