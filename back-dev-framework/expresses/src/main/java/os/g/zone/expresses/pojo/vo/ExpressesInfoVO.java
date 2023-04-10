package os.g.zone.expresses.pojo.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * 查询物流信息 接收参数
 * @Auther: AA
 * @Date: 2023/4/6 01:48
 * @Description: ExpressesInfoVO
 * @Version 1.0.0
 */
@Data
public class ExpressesInfoVO implements Serializable {
    private Long expressesId;
    private String expressesCurrentNodeName;
    private String expressesContactNumber;
    private String expressesContactName;
}
