package os.g.zone.messages.quartz;

import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import os.g.zone.commons.utils.DateUtils;
import os.g.zone.messages.commons.DisplayPositionEnum;
import os.g.zone.messages.socket.service.WebSocketService;
import os.g.zone.messages.socket.vo.BCMessageVO;
import os.g.zone.reports.api.dto.ReportsDataDTO;
import os.g.zone.reports.api.dto.ReportsDataPO;
import os.g.zone.reports.api.service.ReportsInfoService;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * @Auther: AA
 * @Date: 2023/4/10 01:18
 * @Description: ReportsQuartzJob
 * @Version 1.0.0
 */
@Slf4j
public class ReportsQuartzJob implements Job {

    @Autowired
    private WebSocketService webSocketService;
    @DubboReference
    private ReportsInfoService dubboReportsInfoService;
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        Date now = new Date(System.currentTimeMillis());

        ReportsDataPO reportsDataPO = new ReportsDataPO();
        reportsDataPO.setType("0");
        reportsDataPO.setStartTime(new Timestamp(DateUtils.getDayBegin(now).getTime()));
        reportsDataPO.setEndTime(new Timestamp(DateUtils.getDayEnd(now).getTime()));
        List<ReportsDataDTO> reportsDataDTO = dubboReportsInfoService.loadReportsData(reportsDataPO);
        log.debug("报表定时任务数据：【{}】",reportsDataDTO);
        BCMessageVO bcMessageVO = new BCMessageVO<>();
        bcMessageVO.setDisplayPosition(DisplayPositionEnum.REPORTS.getPosition());
        bcMessageVO.setContent(reportsDataDTO);
//        webSocketService.sendToAllMessage(bcMessageVO); // 下发消息

    }
}
