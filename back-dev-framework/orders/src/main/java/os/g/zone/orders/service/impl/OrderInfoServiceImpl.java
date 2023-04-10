package os.g.zone.orders.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import os.g.zone.commons.queue.consts.QueueMsgTags;
import os.g.zone.commons.queue.consts.QueueMsgTopics;
import os.g.zone.commons.results.JsonPage;
import os.g.zone.message.task.api.dto.MessageTaskInfoDTO;
import os.g.zone.message.task.api.service.IMessageTaskInfoService;
import os.g.zone.orders.pojo.bo.OrderInfoBO;
import os.g.zone.orders.pojo.dto.OrderInfoDTO;
import os.g.zone.orders.pojo.entitys.OrderInfo;
import os.g.zone.orders.pojo.po.OrderInfoPO;
import os.g.zone.orders.service.IOrderInfoService;
import os.g.zone.orders.mappers.OrderInfoMapper;
import org.springframework.stereotype.Service;
import os.g.zone.stocks.api.consts.OperatorStockEnum;
import os.g.zone.stocks.api.dto.ChangeStockDTO;
import os.g.zone.stocks.api.service.IStockInfoService;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
* @author AA
* @description 针对表【order_info(订单信息表)】的数据库操作Service实现
* @createDate 2023-03-29 23:57:30
*/
@Slf4j
@Service
public class OrderInfoServiceImpl implements IOrderInfoService {

    @DubboReference
    private IStockInfoService dobboStockInfoService;
    @DubboReference
    private IMessageTaskInfoService iMessageTaskInfoService;
    @Autowired
    private OrderInfoMapper orderInfoMapper;
    @Autowired
    private RocketMQTemplate rocketMQTemplate;
    @Override
    public int insertOrder(OrderInfoDTO orderInfoDTO) {
        ChangeStockDTO changeStockDTO = new ChangeStockDTO();
        changeStockDTO.setProductId(orderInfoDTO.getProductId());
        changeStockDTO.setChangeType(OperatorStockEnum.REDUCE.getType());
        changeStockDTO.setCount(1);
        dobboStockInfoService.changeProductStockById(changeStockDTO);

        OrderInfo orderInfo = new OrderInfo();
        BeanUtils.copyProperties(orderInfoDTO,orderInfo);
        Date now = new Date(System.currentTimeMillis());
        orderInfo.setOrderCreateTime(now);
        int res = orderInfoMapper.insert(orderInfo);

        // 创建一个消息任务 保存消息历史
        MessageTaskInfoDTO messageTaskInfoDTO = new MessageTaskInfoDTO();
        messageTaskInfoDTO.setTaskContent(orderInfo.toString());
        messageTaskInfoDTO.setUId(Long.valueOf(orderInfo.getConsumerId()));
        iMessageTaskInfoService.saveMessageTask(messageTaskInfoDTO);

        // 下发消息
        String dist = "";
        String taskJSONString = "";
        List<String> reciveListArray = new ArrayList<>();
        SendResult sendResult = new SendResult();
        reciveListArray.add(String.valueOf(orderInfo.getConsumerId()));
        // 向下单用户发送订单消息
        messageTaskInfoDTO.setReciveUList(reciveListArray.toString());
        dist = QueueMsgTopics.ORDERS +":"+ QueueMsgTags.SYSTEM_DEFAULT_P2P;
        taskJSONString = JSONObject.toJSONString(messageTaskInfoDTO);
        sendResult = rocketMQTemplate.syncSend(dist, taskJSONString);
        log.debug("向下单用户发送系统通知：【{}】=====【{}】=====【{}】",dist,taskJSONString,sendResult);

        // 向系统用户发送订单消息
        reciveListArray.clear();
        messageTaskInfoDTO.setReciveUList(reciveListArray.toString());
        dist = QueueMsgTopics.ORDERS +":"+ QueueMsgTags.SYSTEM_DEFAULT_BC;
        taskJSONString = JSONObject.toJSONString(messageTaskInfoDTO);
        sendResult = rocketMQTemplate.syncSend(dist, taskJSONString);
        log.debug("广播发送系统通知：【{}】=====【{}】=====【{}】",dist,taskJSONString,sendResult);

        return res;
    }

    @Override
    public int insertBatchOrder(List<OrderInfoDTO> orderInfoDTOS) {
        return 0;
    }

    @Override
    public int removeOrderById(Long pId) {
        return 0;
    }

    @Override
    public int removeBatchOrderByIds(List<Long> oIds) {
        return 0;
    }

    @Override
    public int updateOrderById(OrderInfoDTO orderInfoDTO) {
        OrderInfo newOrderInfo = new OrderInfo();
        BeanUtils.copyProperties(orderInfoDTO,newOrderInfo);
        Date now = new Date(System.currentTimeMillis());
        newOrderInfo.setOrderModifiedTime(now);
        int res = orderInfoMapper.updateById(newOrderInfo);
        return res;
    }

    @Override
    public OrderInfoDTO getOrderById(Long oId) {
        OrderInfoDTO orderInfoDTO = new OrderInfoDTO();
        OrderInfo orderInfo = orderInfoMapper.selectById(oId);
        BeanUtils.copyProperties(orderInfo,orderInfoDTO);
        return orderInfoDTO;
    }

    @Override
    public JsonPage<OrderInfoDTO> listOrderByPage(Long pageIndex, Long pageSize, OrderInfoDTO orderInfoDTO) {
        Page<OrderInfoBO> page = new Page<>(pageIndex,pageSize);
        OrderInfoPO param = new OrderInfoPO();
        BeanUtils.copyProperties(orderInfoDTO,param);
        orderInfoMapper.listAllOrdersByPage(page,param);
        log.debug("数据库分页查询结果：【{}】",page.getRecords());
        log.debug("数据库分页查询记录总数：【{}】",page.getTotal());
        log.debug("数据库分页查询当前页下标：【{}】",page.getCurrent());
        log.debug("数据库分页查询当前页记录数：【{}】",page.getSize());
        log.debug("数据库分页查询总页数：【{}】",page.getPages());
        JsonPage jsonPage = JsonPage.parse(page);
        log.debug(jsonPage.toString());
        return jsonPage;
    }
}




