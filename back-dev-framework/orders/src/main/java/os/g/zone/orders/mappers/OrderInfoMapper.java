package os.g.zone.orders.mappers;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import os.g.zone.orders.pojo.bo.OrderInfoBO;
import os.g.zone.orders.pojo.entitys.OrderInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import os.g.zone.orders.pojo.po.OrderInfoPO;

import java.util.List;

/**
* @author AA
* @description 针对表【order_info(订单信息表)】的数据库操作Mapper
* @createDate 2023-03-29 23:57:30
* @Entity os.g.zone.orders.pojo.entitys.OrderInfo
*/
public interface OrderInfoMapper extends BaseMapper<OrderInfo> {

    Page<OrderInfoBO> listAllOrdersByPage(@Param("page") Page<OrderInfoBO> page,@Param("orderInfoPO") OrderInfoPO orderInfoPO);
}




