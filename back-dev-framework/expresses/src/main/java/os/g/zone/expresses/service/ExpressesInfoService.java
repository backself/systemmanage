package os.g.zone.expresses.service;

import os.g.zone.expresses.pojo.dto.ExpressesDetailInfoDTO;
import os.g.zone.expresses.pojo.dto.ExpressesInfoDTO;

import java.util.List;

/**
 * @Auther: AA
 * @Date: 2023/4/6 01:50
 * @Description: ExpressesInfoService
 * @Version 1.0.0
 */
public interface ExpressesInfoService {
    /**
     * 新增物流信息方法
     * @Auther: AA
     * @Date: 2023/4/6 1:50
     * @Version 1.0.0
     */
    int saveExpressesInfo(ExpressesInfoDTO expressesInfoDTO);
    int appendExpressesInfo(ExpressesInfoDTO expressesInfoDTO);
    ExpressesDetailInfoDTO listExpressesInfoById(ExpressesInfoDTO expressesInfoDTO);

}
