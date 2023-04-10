package os.g.zone.sys.urls.api.service;

import os.g.zone.sys.urls.api.dto.SystemUrlDTO;
import os.g.zone.sys.urls.api.dto.TreeMenuDTO;

import java.util.List;

/**
* @author AA
* @description 针对表【system_url(链接表)】的数据库操作Service
* @createDate 2023-03-29 23:57:30
*/
public interface ISystemUrlService {

    int insertSystemUrl(SystemUrlDTO systemUrlDTO);
    int insertBatchSystemUrl(List<SystemUrlDTO> systemUrlDTOS);
    int removeSystemUrlById(Long uId);
    int removeBatchSystemUrlByIds(List<Long> sIds);
    int updateSystemUrlById(SystemUrlDTO systemUrlDTO);
    SystemUrlDTO getSystemUrlById(Long sId);
    List<SystemUrlDTO> listSystemUrls(SystemUrlDTO systemUrlDTO);
    List<TreeMenuDTO> listSystemNavUrl();

}
