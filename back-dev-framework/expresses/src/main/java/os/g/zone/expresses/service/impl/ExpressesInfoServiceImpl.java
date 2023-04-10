package os.g.zone.expresses.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import os.g.zone.expresses.pojo.dto.ExpressesDetailInfoDTO;
import os.g.zone.expresses.pojo.dto.ExpressesInfoDTO;
import os.g.zone.expresses.pojo.entitys.ExpressesInfo;
import os.g.zone.expresses.service.ExpressesInfoService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Auther: AA
 * @Date: 2023/4/6 01:52
 * @Description: ExpressesInfoServiceImpl
 * @Version 1.0.0
 */
@Service
@Slf4j
public class ExpressesInfoServiceImpl implements ExpressesInfoService {
    @Override
    public int saveExpressesInfo(ExpressesInfoDTO expressesInfoDTO) {
        ExpressesInfo expressesInfo = new ExpressesInfo();
        BeanUtils.copyProperties(expressesInfoDTO,expressesInfo);
        List<Map> history = new ArrayList<>();
        expressesInfo.setExpressHistroy(history);
        log.debug("创建物流：【{}】",expressesInfo);
        return 0;
    }

    @Override
    public int appendExpressesInfo(ExpressesInfoDTO expressesInfoDTO) {
        ExpressesInfo expressesInfo = new ExpressesInfo();
        expressesInfo.setExpressesId(expressesInfoDTO.getExpressesId());
        List<Map> history = new ArrayList<>();
        expressesInfo.setExpressHistroy(history);
        // 获取当前最新信息
        // 将当前最新物流信息保存到历史记录字段中
        // 更新物流信息
        log.debug("追加物流信息：【{}】",expressesInfo);
        return 0;
    }

    @Override
    public ExpressesDetailInfoDTO listExpressesInfoById(ExpressesInfoDTO expressesInfoDTO) {
        ExpressesDetailInfoDTO expressesDetailInfoDTO = new ExpressesDetailInfoDTO();

        log.debug("物流详情信息：【{}】",expressesDetailInfoDTO);
        return expressesDetailInfoDTO;
    }
}
