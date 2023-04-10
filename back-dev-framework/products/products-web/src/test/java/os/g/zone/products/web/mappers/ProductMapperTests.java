package os.g.zone.products.web.mappers;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import os.g.zone.commons.results.JsonPage;
import os.g.zone.products.web.pojo.bo.ProductInfoBO;
import os.g.zone.products.web.pojo.entitys.ProductInfo;
import os.g.zone.products.web.pojo.po.ProductInfoPo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@SpringBootTest
public class ProductMapperTests {
    @Autowired
    private ProductMapper productMapper;

    @Test
    public void test(){
        int product =  productMapper.deleteById(1L);
        log.debug("获得结果为：{}",product);
    }

    @Test
    public void testSelf(){
        ProductInfoPo product = new ProductInfoPo();
        product.setProductName("AAAA");
        product.setProductRepertories(1111);
        product.setProductStatus(1);
        product.setProductType(1);
        Timestamp create = new Timestamp(System.currentTimeMillis());

        product.setProductCreateTime(create);
        product.setProductCommonLevel(1111);
        product.setProductSpecLevel(0);

        ProductInfo param = new ProductInfo();
        BeanUtils.copyProperties(product,param);
        log.debug("传入参数，{}",product);
        int count = productMapper.insert(param);
        log.debug("插入成功：{}",count);
    }
    @Test
    public void testPageHelper(){
        Page<ProductInfo> page = new Page<>(1,5);
        QueryWrapper<ProductInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("product_name","A");
        productMapper.selectPage(page,queryWrapper);
        log.debug("数据库分页查询结果：【{}】",page.getRecords());
        log.debug("数据库分页查询记录总数：【{}】",page.getTotal());
        log.debug("数据库分页查询当前页下标：【{}】",page.getCurrent());
        log.debug("数据库分页查询当前页记录数：【{}】",page.getSize());
        log.debug("数据库分页查询总页数：【{}】",page.getPages());
    }

    @Test
    public void testMyBatisPlusSelfMethodHelper(){
        Page<ProductInfoBO> page = new Page<>(1,5);
        productMapper.listAllProductByPage(page);
        log.debug("数据库分页查询结果：【{}】",page.getRecords());
        log.debug("数据库分页查询记录总数：【{}】",page.getTotal());
        log.debug("数据库分页查询当前页下标：【{}】",page.getCurrent());
        log.debug("数据库分页查询当前页记录数：【{}】",page.getSize());
        log.debug("数据库分页查询总页数：【{}】",page.getPages());
        JsonPage jsonPage = JsonPage.parse(page);
        log.debug(jsonPage.toString());
    }

    @Test
    public void testMyBatisBatchUpdate(){
        List pIds = new ArrayList<>();
        pIds.add("1025");
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductIsDel(1);
        QueryWrapper<ProductInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("product_id",pIds);
        int res = productMapper.update(productInfo,queryWrapper);
        log.debug("{}",res);
    }


}
