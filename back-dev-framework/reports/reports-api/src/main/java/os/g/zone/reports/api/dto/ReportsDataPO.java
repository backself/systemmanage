package os.g.zone.reports.api.dto;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 报表数据类
 * @Auther: AA
 * @Date: 2023/4/8 10:53
 * @Description: ReportsInfoPO
 * @Version 1.0.0
 */
@Data
public class ReportsDataPO implements Serializable {

    /**
     * 报表类型
     * @Auther: AA
     * @Date: 2023/4/8 10:55
     * @Version 1.0.0
     */
    private String type;

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
