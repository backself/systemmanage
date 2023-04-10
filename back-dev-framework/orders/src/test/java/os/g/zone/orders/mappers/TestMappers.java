package os.g.zone.orders.mappers;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import os.g.zone.commons.results.JsonPage;
import os.g.zone.orders.pojo.bo.OrderInfoBO;
import os.g.zone.orders.pojo.entitys.OrderInfo;
import os.g.zone.orders.pojo.po.OrderInfoPO;

import java.sql.Timestamp;

/**
 * @Auther: AA
 * @Date: 2023/3/30 00:13
 * @Description: TestMappers
 * @Version 1.0.0
 */
@Slf4j
@SpringBootTest
public class TestMappers {
    @Autowired
    private OrderInfoMapper orderInfoMapper;

    @Test
    public void test(){
        int product =  orderInfoMapper.deleteById(1L);
        log.debug("获得结果为：{}",product);
    }

    @Test
    public void testSelf(){
        OrderInfo order = new OrderInfo();
        order.setConsumerId(1111L);
        order.setOrderStatus("1");
        order.setProductId(1L);
        Timestamp create = new Timestamp(System.currentTimeMillis());

        order.setOrderCreateTime(create);

        OrderInfo param = new OrderInfo();
        BeanUtils.copyProperties(order,param);
        log.debug("传入参数，{}",order);
        int count = orderInfoMapper.insert(param);
        log.debug("插入成功：{}",count);
    }
    @Test
    public void testPageHelper(){
        Page<OrderInfo> page = new Page<>(1,5);
        QueryWrapper<OrderInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("order_status","A");
        orderInfoMapper.selectPage(page,queryWrapper);
        log.debug("数据库分页查询结果：【{}】",page.getRecords());
        log.debug("数据库分页查询记录总数：【{}】",page.getTotal());
        log.debug("数据库分页查询当前页下标：【{}】",page.getCurrent());
        log.debug("数据库分页查询当前页记录数：【{}】",page.getSize());
        log.debug("数据库分页查询总页数：【{}】",page.getPages());
    }

    @Test
    public void testMyBatisPlusSelfMethodHelper(){
        Page<OrderInfoBO> page = new Page<>(1,5);
        OrderInfoPO param = new OrderInfoPO();
        param.setProductId(1L);
        orderInfoMapper.listAllOrdersByPage(page,param);
        log.debug("数据库分页查询结果：【{}】",page.getRecords());
        log.debug("数据库分页查询记录总数：【{}】",page.getTotal());
        log.debug("数据库分页查询当前页下标：【{}】",page.getCurrent());
        log.debug("数据库分页查询当前页记录数：【{}】",page.getSize());
        log.debug("数据库分页查询总页数：【{}】",page.getPages());
        JsonPage jsonPage = JsonPage.parse(page);
        log.debug(jsonPage.toString());
    }
}
