package os.g.zone.sys.urls.web.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import os.g.zone.commons.consts.ReplyCode;
import os.g.zone.commons.exceptions.ServiceException;
import os.g.zone.sys.urls.api.dto.TreeMenuDTO;
import os.g.zone.sys.urls.web.mappers.SystemUrlMapper;
import os.g.zone.sys.urls.api.dto.SystemUrlDTO;
import os.g.zone.sys.urls.web.pojo.bo.TreeMenuBO;
import os.g.zone.sys.urls.web.pojo.entitys.SystemUrl;
import os.g.zone.sys.urls.web.pojo.po.SystemUrlPO;
import os.g.zone.sys.urls.api.service.ISystemUrlService;

import java.util.ArrayList;
import java.util.List;

/**
* @author AA
* @description 针对表【order_info(订单信息表)】的数据库操作Service实现
* @createDate 2023-03-29 23:57:30
*/
@Slf4j
@Service
@DubboService
public class SystemUrlServiceImpl implements ISystemUrlService {

    @Autowired
    private SystemUrlMapper systemUrlMapper;


    @Override
    public int insertSystemUrl(SystemUrlDTO systemUrlDTO) {

        String name = systemUrlDTO.getUrlName();
        int count = systemUrlMapper.countByName(name);
        if (count>0){
            String message = "添加链接失败，链接名称已被占用！";
            log.warn(message);
            throw new ServiceException(ReplyCode.RES_ERROR,message);
        }
        SystemUrl systemUrl = new SystemUrl();
        BeanUtils.copyProperties(systemUrlDTO,systemUrl);
        int res = systemUrlMapper.insert(systemUrl);
        return res;
    }

    @Override
    public int insertBatchSystemUrl(List<SystemUrlDTO> systemUrlDTOS) {
        return 0;
    }

    @Override
    public int removeSystemUrlById(Long uId) {
        return 0;
    }

    @Override
    public int removeBatchSystemUrlByIds(List<Long> sIds) {
        return 0;
    }

    @Override
    public int updateSystemUrlById(SystemUrlDTO systemUrlDTO) {

        int count = systemUrlMapper.countByName(systemUrlDTO.getUrlName());
        if (count>1){
            String message = "修改链接失败，链接名称已被占用！";
            log.warn(message);
            throw new ServiceException(ReplyCode.RES_ERROR,message);
        }
        SystemUrl newSystemUrl = new SystemUrl();
        BeanUtils.copyProperties(systemUrlDTO,newSystemUrl);
        int res = systemUrlMapper.updateById(newSystemUrl);
        return res;
    }

    @Override
    public SystemUrlDTO getSystemUrlById(Long sId) {
        SystemUrlDTO systemUrlDTO = new SystemUrlDTO();
        SystemUrl systemUrl = systemUrlMapper.selectById(sId);
        BeanUtils.copyProperties(systemUrlDTO,systemUrl);
        return systemUrlDTO;
    }

    @Override
    public List<SystemUrlDTO> listSystemUrls( SystemUrlDTO systemUrlDTO) {
        QueryWrapper<SystemUrl> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("url_status",0); // 选定可用的url
        List<SystemUrl> res = systemUrlMapper.selectList(queryWrapper);
        List<SystemUrlDTO> resNav = new ArrayList<>();
        res.forEach((item)->{
            SystemUrlDTO systemUrlTempDTO = new SystemUrlDTO();
            BeanUtils.copyProperties(item,systemUrlTempDTO);
            resNav.add(systemUrlTempDTO);
        });
        return resNav;
    }

    @Override
    public List<TreeMenuDTO> listSystemNavUrl() {
        SystemUrlPO systemUrlPO = new SystemUrlPO();
        systemUrlPO.setUrlType(0);
        List<TreeMenuBO> menuTree = systemUrlMapper.getMenuTree(systemUrlPO);
        List<TreeMenuDTO> resTreeDTO = parseBOTreeDTO(menuTree);
        return resTreeDTO;
    }




    /**
     * 将maper查询出来的结果从BO转换为DTO
     * @param menuTreeBO 查询结果BO
     * @return
     */
    public List<TreeMenuDTO> parseBOTreeDTO(List<TreeMenuBO> menuTreeBO){
        List<TreeMenuDTO> res = new ArrayList<>();
        for (TreeMenuBO item:menuTreeBO) {
            TreeMenuDTO dto = new TreeMenuDTO();
            dto.setUrlId(item.getUrlId());
            dto.setUrlName(item.getUrlName());
            dto.setUrlLink(item.getUrlLink());
            dto.setParentId(item.getParentId());
            dto.setUrlType(item.getUrlType());
            if (item.getChilds() != null && item.getChilds().size() > 0){
                List<TreeMenuDTO> temp = new ArrayList<>();
                temp = parseBOTreeDTO(item.getChilds());
                dto.setChilds(temp);
            }
            res.add(dto);
        }
        log.debug(res.toString());
        return res;
    }
}




