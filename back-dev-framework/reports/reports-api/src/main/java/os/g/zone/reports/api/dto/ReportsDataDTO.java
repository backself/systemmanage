package os.g.zone.reports.api.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: AA
 * @Date: 2023/4/8 13:15
 * @Description: ReportsDataDTO
 * @Version 1.0.0
 */
@Data
public class ReportsDataDTO implements Serializable {
    /**
     * 报表名称
     * @Auther: AA
     * @Date: 2023/4/8 13:17
     * @Version 1.0.0
     */
    private String name;
    /**
     * 报表显示的图例颜色
     * @Auther: AA
     * @Date: 2023/4/8 13:17
     * @Version 1.0.0
     */
    private String color;
    /**
     * 报表数据载体
     * @Auther: AA
     * @Date: 2023/4/8 13:17
     * @Version 1.0.0
     */
    private List<HashMap<String,Object>> data;
}
