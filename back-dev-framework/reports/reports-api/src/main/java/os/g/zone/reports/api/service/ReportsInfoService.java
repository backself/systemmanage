package os.g.zone.reports.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import os.g.zone.reports.api.dto.ReportsDataDTO;
import os.g.zone.reports.api.dto.ReportsDataPO;

import java.util.List;

/**
* @author AA
* @description 针对表【order_info(订单信息表)】的数据库操作Service
* @createDate 2023-04-08 10:29:53
*/
public interface ReportsInfoService {

    List<ReportsDataDTO> loadReportsData(ReportsDataPO reportsDataPO);
}
