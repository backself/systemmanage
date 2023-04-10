package os.g.zone.sys.urls.web.mappers;

import os.g.zone.sys.urls.web.pojo.bo.TreeMenuBO;
import os.g.zone.sys.urls.web.pojo.entitys.SystemUrl;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import os.g.zone.sys.urls.web.pojo.po.SystemUrlPO;

import java.util.List;

/**
* @author 83416
* @description 针对表【system_url(链接表（
* @createDate 2023-03-30 19:57:45
* @Entity entitys.pojo.os.g.zone.sys.urls.SystemUrl
*/
public interface SystemUrlMapper extends BaseMapper<SystemUrl> {




    int countByName(String name);

    List<TreeMenuBO> getMenuTree(SystemUrlPO systemUrlPO);

}




