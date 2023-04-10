package os.g.zone.expresses.pojo.dto;

import lombok.Data;

import java.sql.Date;
import java.util.List;
import java.util.Map;

/**
 * 物流 数据传输实体
 * @Auther: AA
 * @Date: 2023/4/6 01:47
 * @Description: ExpressesInfoDTO
 * @Version 1.0.0
 */
@Data
public class ExpressesInfoDTO {
    private Long expressesId; // 单号
    private String expressesName; // 物流名称
    private String expressesCurrentNodeName; // 物流节点名称
    private String expressesContactNumber ; // 联系方式
    private String expressesContactName ; // 联系人名称
    private Date expressTime; // 站点接收时间
}
