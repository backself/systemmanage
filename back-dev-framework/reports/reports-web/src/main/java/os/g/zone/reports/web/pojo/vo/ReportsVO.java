package os.g.zone.reports.web.pojo.vo;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @Auther: AA
 * @Date: 2023/4/8 13:45
 * @Description: ReportsVO
 * @Version 1.0.0
 */
@Data
public class ReportsVO {
    /**
     * 报表起始时间
     * @Auther: AA
     * @Date: 2023/4/8 10:55
     * @Version 1.0.0
     */
    private Timestamp startTime;
    /**
     * 报表结束时间
     * @Auther: AA
     * @Date: 2023/4/8 10:55
     * @Version 1.0.0
     */
    private Timestamp endTime;
}
