package os.g.zone.expresses.pojo.dto;

import lombok.Data;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.Map;

/**
 * 物流详情信息实体
 * @Auther: AA
 * @Date: 2023/4/6 01:30
 * @Description: ExpressesInfo
 * @Version 1.0.0
 */
@Data
public class ExpressesDetailInfoDTO implements Serializable {
    private Long expressesId; // 单号
    private String expressesName; // 物流名称
    private String expressesCurrentNodeName; // 物流节点名称
    private String expressesContactNumber ; // 联系方式
    private String expressesContactName ; // 联系人名称
    private List<Map> expressHistroy;// [{time:1,address:asdf}]
    private Date expressTime; // 站点接收时间
}
