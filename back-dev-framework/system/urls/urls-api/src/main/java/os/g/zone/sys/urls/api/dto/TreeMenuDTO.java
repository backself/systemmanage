package os.g.zone.sys.urls.api.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Auther: AA
 * @Date: 2023/4/7 11:03
 * @Description: TreeMenuBO
 * @Version 1.0.0
 */
@Data
public class TreeMenuDTO implements Serializable {
    private Long urlId;
    private String urlName;
    private String urlLink;
    private Long parentId;
    private Integer urlType;
    private List<TreeMenuDTO> childs;

}
