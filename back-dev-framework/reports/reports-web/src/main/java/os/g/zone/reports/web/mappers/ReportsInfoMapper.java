package os.g.zone.reports.web.mappers;

import os.g.zone.reports.web.pojo.entitys.ReportsInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import os.g.zone.reports.web.pojo.po.ReportsInfoPO;

import java.util.HashMap;
import java.util.List;

/**
* @author AA
* @description 针对表【order_info(订单信息表)】的数据库操作Mapper
* @createDate 2023-04-08 10:29:53
* @Entity os.g.zone.reports.web.entitys.pojo.ReportsInfo
*/
public interface ReportsInfoMapper extends BaseMapper<ReportsInfo> {

    List<HashMap<String,Object>> loadDateReportsDataByTime(ReportsInfoPO reportsInfoPO);

    List<HashMap<String,Object>> loadMonthReportsDataByTime(ReportsInfoPO reportsInfoPO);
    List<HashMap<String,Object>> loadYearReportsDataByTime(ReportsInfoPO reportsInfoPO);
}




