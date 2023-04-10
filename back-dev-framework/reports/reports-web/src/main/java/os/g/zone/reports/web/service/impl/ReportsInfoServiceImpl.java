package os.g.zone.reports.web.service.impl;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import os.g.zone.reports.api.dto.ReportsDataDTO;
import os.g.zone.reports.api.dto.ReportsDataPO;
import os.g.zone.reports.api.service.ReportsInfoService;
import os.g.zone.reports.web.consts.ReportsEnum;
import os.g.zone.reports.web.pojo.po.ReportsInfoPO;
import os.g.zone.reports.web.mappers.ReportsInfoMapper;
import org.springframework.stereotype.Service;
import os.g.zone.commons.utils.DateUtils;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
* @author AA
* @description 针对表【order_info(订单信息表)】的数据库操作Service实现
* @createDate 2023-04-08 10:29:53
*/
@Service
@DubboService
public class ReportsInfoServiceImpl implements ReportsInfoService {

    @Autowired
    private ReportsInfoMapper reportsInfoMapper;

    @Override
    public List<ReportsDataDTO> loadReportsData(ReportsDataPO reportsDataPO) {
        ReportsInfoPO reportsInfoPO = new ReportsInfoPO(); // mapper入参
        List<ReportsDataDTO> reportsReusltData = new ArrayList<>(); // 报表数据完整结果
        List<HashMap<String,Object>> mapperResult = new ArrayList<>(); // mapper查询结果

        ReportsDataDTO reportsItemDataDTO = new ReportsDataDTO(); // 报表数据项
        String title = ""; // 报表数据项标题
        Date compareStartTime = reportsInfoPO.getStartTime();
        Date compareEndTime = compareStartTime; // 以当前开始时间作为结束时间

        BeanUtils.copyProperties(reportsDataPO,reportsInfoPO);

        List all = new ArrayList<>();
        if (ReportsEnum.DALIY.getValue().equals(reportsDataPO.getType())){
            mapperResult = reportsInfoMapper.loadDateReportsDataByTime(reportsInfoPO);
            title = DateUtils.getDate(reportsInfoPO.getStartTime(),"yyyy-MM-dd")+ReportsEnum.DALIY.getReportName();
            reportsItemDataDTO.setName(title);
            reportsItemDataDTO.setColor(ReportsEnum.DALIY.getReportColor());
            reportsItemDataDTO.setData(mapperResult);
            reportsReusltData.add(reportsItemDataDTO);

            reportsItemDataDTO = new ReportsDataDTO(); // 报表数据项
            compareStartTime = reportsInfoPO.getStartTime();
            compareEndTime = compareStartTime; // 以当前开始时间作为结束时间
            compareStartTime = DateUtils.dateReduceDay(new Date(compareStartTime.getTime()),1);// 更新开始时间为3天前
            reportsInfoPO.setStartTime(new Timestamp(compareStartTime.getTime()));
            reportsInfoPO.setEndTime(new Timestamp(compareEndTime.getTime()));
            mapperResult = reportsInfoMapper.loadDateReportsDataByTime(reportsInfoPO);
            title = DateUtils.getDate(reportsInfoPO.getStartTime(),"yyyy-MM-dd")+ReportsEnum.DALIY.getReportName();
            reportsItemDataDTO.setName(title);
            reportsItemDataDTO.setColor(ReportsEnum.DALIY.getReportColor());
            reportsItemDataDTO.setData(mapperResult);
            reportsReusltData.add(reportsItemDataDTO);

            reportsItemDataDTO = new ReportsDataDTO(); // 报表数据项
            compareStartTime = reportsInfoPO.getStartTime();
            compareEndTime = compareStartTime; // 以当前开始时间作为结束时间
            compareStartTime = DateUtils.dateReduceDay(new Date(compareStartTime.getTime()),1);// 更新开始时间为3天前
            reportsInfoPO.setStartTime(new Timestamp(compareStartTime.getTime()));
            reportsInfoPO.setEndTime(new Timestamp(compareEndTime.getTime()));
            mapperResult = reportsInfoMapper.loadDateReportsDataByTime(reportsInfoPO);
            title = DateUtils.getDate(reportsInfoPO.getStartTime(),"yyyy-MM-dd")+ReportsEnum.DALIY.getReportName();
            reportsItemDataDTO.setName(title);
            reportsItemDataDTO.setColor(ReportsEnum.DALIY.getReportColor());
            reportsItemDataDTO.setData(mapperResult);
            reportsReusltData.add(reportsItemDataDTO);
        }
        if (ReportsEnum.WEEK.getValue().equals(reportsDataPO.getType())){

            mapperResult = reportsInfoMapper.loadMonthReportsDataByTime(reportsInfoPO);
            title = "本"+ReportsEnum.WEEK.getReportName();
            reportsItemDataDTO.setName(title);
            reportsItemDataDTO.setColor(ReportsEnum.WEEK.getReportColor());
            reportsItemDataDTO.setData(mapperResult);
            reportsReusltData.add(reportsItemDataDTO);

            reportsItemDataDTO = new ReportsDataDTO(); // 报表数据项
            compareStartTime = reportsInfoPO.getStartTime();
            compareEndTime = compareStartTime; // 以当前开始时间作为结束时间
            compareStartTime = DateUtils.dateReduceDay(new Date(compareStartTime.getTime()),7);// 更新开始时间为7天前
            reportsInfoPO.setStartTime(new Timestamp(compareStartTime.getTime()));
            reportsInfoPO.setEndTime(new Timestamp(compareEndTime.getTime()));
            mapperResult = reportsInfoMapper.loadMonthReportsDataByTime(reportsInfoPO);
            title = "上"+ReportsEnum.WEEK.getReportName();
            reportsItemDataDTO.setName(title);
            reportsItemDataDTO.setColor(ReportsEnum.WEEK.getReportColor());
            reportsItemDataDTO.setData(mapperResult);
            reportsReusltData.add(reportsItemDataDTO);

            reportsItemDataDTO = new ReportsDataDTO(); // 报表数据项
            compareStartTime = reportsInfoPO.getStartTime();
            compareEndTime = compareStartTime; // 以当前开始时间作为结束时间
            compareStartTime = DateUtils.dateReduceDay(new Date(compareStartTime.getTime()),7);// 更新开始时间为7天前
            reportsInfoPO.setStartTime(new Timestamp(compareStartTime.getTime()));
            reportsInfoPO.setEndTime(new Timestamp(compareEndTime.getTime()));
            mapperResult = reportsInfoMapper.loadMonthReportsDataByTime(reportsInfoPO);
            title = "上上"+ReportsEnum.WEEK.getReportName();
            reportsItemDataDTO.setName(title);
            reportsItemDataDTO.setColor(ReportsEnum.WEEK.getReportColor());
            reportsItemDataDTO.setData(mapperResult);
            reportsReusltData.add(reportsItemDataDTO);
        }
        if (ReportsEnum.MONTH.getValue().equals(reportsDataPO.getType())){

            mapperResult = reportsInfoMapper.loadMonthReportsDataByTime(reportsInfoPO);
            title = DateUtils.getDate(reportsInfoPO.getStartTime(),"yyyy-MM")+ReportsEnum.MONTH.getReportName();
            reportsItemDataDTO.setName(title);
            reportsItemDataDTO.setColor(ReportsEnum.DALIY.getReportColor());
            reportsItemDataDTO.setData(mapperResult);
            reportsReusltData.add(reportsItemDataDTO);

            reportsItemDataDTO = new ReportsDataDTO(); // 报表数据项
            compareStartTime = reportsInfoPO.getStartTime();
            compareEndTime = compareStartTime; // 以当前开始时间作为结束时间
            compareStartTime = DateUtils.dateReduceMonth(new Date(compareStartTime.getTime()),1);// 更新开始时间为一个月前
            reportsInfoPO.setStartTime(new Timestamp(compareStartTime.getTime()));
            reportsInfoPO.setEndTime(new Timestamp(compareEndTime.getTime()));
            mapperResult = reportsInfoMapper.loadMonthReportsDataByTime(reportsInfoPO);
            title = DateUtils.getDate(reportsInfoPO.getStartTime(),"yyyy-MM")+ReportsEnum.MONTH.getReportName();
            reportsItemDataDTO.setName(title);
            reportsItemDataDTO.setColor(ReportsEnum.MONTH.getReportColor());
            reportsItemDataDTO.setData(mapperResult);
            reportsReusltData.add(reportsItemDataDTO);

            reportsItemDataDTO = new ReportsDataDTO(); // 报表数据项
            compareStartTime = reportsInfoPO.getStartTime();
            compareEndTime = compareStartTime; // 以当前开始时间作为结束时间
            compareStartTime = DateUtils.dateReduceMonth(new Date(compareStartTime.getTime()),1);// 更新开始时间为3天前
            reportsInfoPO.setStartTime(new Timestamp(compareStartTime.getTime()));
            reportsInfoPO.setEndTime(new Timestamp(compareEndTime.getTime()));
            mapperResult = reportsInfoMapper.loadMonthReportsDataByTime(reportsInfoPO);
            title = DateUtils.getDate(reportsInfoPO.getStartTime(),"yyyy-MM")+ReportsEnum.MONTH.getReportName();
            reportsItemDataDTO.setName(title);
            reportsItemDataDTO.setColor(ReportsEnum.MONTH.getReportColor());
            reportsItemDataDTO.setData(mapperResult);
            reportsReusltData.add(reportsItemDataDTO);
        }
        if (ReportsEnum.YEAR.getValue().equals(reportsDataPO.getType())){

            mapperResult = reportsInfoMapper.loadYearReportsDataByTime(reportsInfoPO);
            title = DateUtils.getDate(reportsInfoPO.getStartTime(),"yyyy")+ReportsEnum.YEAR.getReportName();
            reportsItemDataDTO.setName(title);
            reportsItemDataDTO.setColor(ReportsEnum.YEAR.getReportColor());
            reportsItemDataDTO.setData(mapperResult);
            reportsReusltData.add(reportsItemDataDTO);

            reportsItemDataDTO = new ReportsDataDTO(); // 报表数据项
            compareStartTime = reportsInfoPO.getStartTime();
            compareEndTime = compareStartTime; // 以当前开始时间作为结束时间
            compareStartTime = DateUtils.dateReduceYear(new Date(compareStartTime.getTime()),1);// 更新开始时间为一个月前
            reportsInfoPO.setStartTime(new Timestamp(compareStartTime.getTime()));
            reportsInfoPO.setEndTime(new Timestamp(compareEndTime.getTime()));
            mapperResult = reportsInfoMapper.loadYearReportsDataByTime(reportsInfoPO);
            title = DateUtils.getDate(reportsInfoPO.getStartTime(),"yyyy")+ReportsEnum.YEAR.getReportName();
            reportsItemDataDTO.setName(title);
            reportsItemDataDTO.setColor(ReportsEnum.MONTH.getReportColor());
            reportsItemDataDTO.setData(mapperResult);
            reportsReusltData.add(reportsItemDataDTO);

            reportsItemDataDTO = new ReportsDataDTO(); // 报表数据项
            compareStartTime = reportsInfoPO.getStartTime();
            compareEndTime = compareStartTime; // 以当前开始时间作为结束时间
            compareStartTime = DateUtils.dateReduceYear(new Date(compareStartTime.getTime()),1);// 更新开始时间为3天前
            reportsInfoPO.setStartTime(new Timestamp(compareStartTime.getTime()));
            reportsInfoPO.setEndTime(new Timestamp(compareEndTime.getTime()));
            mapperResult = reportsInfoMapper.loadYearReportsDataByTime(reportsInfoPO);
            title = DateUtils.getDate(reportsInfoPO.getStartTime(),"yyyy")+ReportsEnum.YEAR.getReportName();
            reportsItemDataDTO.setName(title);
            reportsItemDataDTO.setColor(ReportsEnum.MONTH.getReportColor());
            reportsItemDataDTO.setData(mapperResult);
            reportsReusltData.add(reportsItemDataDTO);
        }


        return reportsReusltData;
    }
}




