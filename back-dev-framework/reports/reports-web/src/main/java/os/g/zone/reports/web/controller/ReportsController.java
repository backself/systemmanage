package os.g.zone.reports.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import os.g.zone.commons.results.JsonResult;
import os.g.zone.reports.api.dto.ReportsDataDTO;
import os.g.zone.reports.api.dto.ReportsDataPO;
import os.g.zone.reports.api.service.ReportsInfoService;
import os.g.zone.reports.web.pojo.vo.ReportsVO;
import os.g.zone.reports.web.utils.CSVFileTools;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * @Auther: AA
 * @Date: 2023/4/8 13:43
 * @Description: ReportsController
 * @Version 1.0.0
 */
@RestController
@Slf4j
public class ReportsController {
    @DubboReference
    private ReportsInfoService dubboReportsInfoService;
    @RequestMapping("/get/{reportType}")
    public JsonResult getReport(@PathVariable("reportType") String reportType, ReportsVO reportsVO){
        log.debug("请求参数：【{}】",reportsVO);

        ReportsDataPO reportsDataPO = new ReportsDataPO();
        reportsDataPO.setType(reportType);
        reportsDataPO.setStartTime(reportsVO.getStartTime());
        reportsDataPO.setEndTime(reportsVO.getEndTime());
        List<ReportsDataDTO> reportsDataDTO = dubboReportsInfoService.loadReportsData(reportsDataPO);
        return JsonResult.success(reportsDataDTO);
    }
    @RequestMapping("/download/{reportType}")
    @ResponseBody
    public JsonResult downloadReport(@PathVariable("reportType") String reportType, ReportsVO reportsVO, HttpServletResponse response) throws IOException {
        log.debug("请求参数：【{}】",reportsVO);

        ReportsDataPO reportsDataPO = new ReportsDataPO();
        reportsDataPO.setType(reportType);
        reportsDataPO.setStartTime(reportsVO.getStartTime());
        reportsDataPO.setEndTime(reportsVO.getEndTime());
        List<ReportsDataDTO> reportsDataDTO = dubboReportsInfoService.loadReportsData(reportsDataPO);

        OutputStream os = response.getOutputStream();

        CSVFileTools.responseSetProperties("",response);
        CSVFileTools.doExportListData(reportsDataDTO,"日期,数据","time,data",os);
        return null;
    }
}
