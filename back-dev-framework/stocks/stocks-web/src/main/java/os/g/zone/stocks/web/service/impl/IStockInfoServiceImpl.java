package os.g.zone.stocks.web.service.impl;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import os.g.zone.commons.queue.consts.QueueMsgTags;
import os.g.zone.commons.queue.consts.QueueMsgTopics;
import os.g.zone.message.task.api.dto.MessageTaskInfoDTO;
import os.g.zone.message.task.api.service.IMessageTaskInfoService;
import os.g.zone.stocks.api.dto.ChangeStockDTO;
import os.g.zone.stocks.api.dto.UpdateStockDTO;
import os.g.zone.stocks.api.service.IStockInfoService;
import os.g.zone.stocks.api.consts.OperatorStockEnum;
import os.g.zone.stocks.web.mappers.StockInfoMapper;
import os.g.zone.stocks.web.pojo.entitys.StockInfo;
import os.g.zone.stocks.web.pojo.po.ChangeStockPO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author AA
 * @description 针对表【product_info(产品信息表)】的数据库操作Service实现
 * @createDate 2023-04-05 22:44:47
 */
@Service
@DubboService
@Slf4j
public class IStockInfoServiceImpl implements IStockInfoService {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @DubboReference
    private IMessageTaskInfoService iMessageTaskInfoService;

    @Autowired
    private StockInfoMapper stockInfoMapper;

    @Override
    public int changeProductStockById(ChangeStockDTO changeStockDTO) {
        ChangeStockPO changeStockPO = new ChangeStockPO();
        BeanUtils.copyProperties(changeStockDTO, changeStockPO);
        int res = stockInfoMapper.changeProductStockById(changeStockPO);
        log.debug("商品id【{}】减库存【{}】结果影响行数【{}】", changeStockDTO.getProductId(), changeStockDTO.getCount(), res);

        StockInfo stockInfo = stockInfoMapper.selectById(changeStockDTO.getProductId());

        // 创建系统消息任务
        MessageTaskInfoDTO messageTaskInfoDTO = new MessageTaskInfoDTO();
        String taskString = JSONObject.toJSONString(stockInfo);
        messageTaskInfoDTO.setTaskContent(taskString);
        messageTaskInfoDTO.setReciveUList("");
        messageTaskInfoDTO.setUId(0L); // 指定任务创建者 0，默认为系统发送
        iMessageTaskInfoService.saveMessageTask(messageTaskInfoDTO);

        // 下发消息
        String dist = "";
        String taskJSONString = "";
        SendResult sendResult = new SendResult();

        dist = QueueMsgTopics.STOCKS +":"+ QueueMsgTags.SYSTEM_DEFAULT_BC;
        taskJSONString = JSONObject.toJSONString(messageTaskInfoDTO);
        sendResult = rocketMQTemplate.syncSend(dist, taskJSONString);
        log.debug("向系统用户发送系统通知：【{}】=====【{}】=====【{}】",dist,taskJSONString,sendResult);

        return res;
    }

    @Override
    public int updateProductStockById(UpdateStockDTO updateStockDTO) {
        StockInfo stockInfo = new StockInfo();
        stockInfo.setProductId(updateStockDTO.getProductId());
        stockInfo.setProductRepertories(updateStockDTO.getCount());
        int res = stockInfoMapper.updateById(stockInfo);
        log.debug("商品id【{}】变更库存【{}】结果影响行数【{}】", updateStockDTO.getProductId(), stockInfo.getProductRepertories(), res);
        return res;
    }
}




