package os.g.zone.products.web.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import os.g.zone.commons.results.JsonPage;
import os.g.zone.products.api.dto.ProductDTO;
import os.g.zone.products.api.service.IProductService;
import os.g.zone.products.web.mappers.ProductMapper;
import os.g.zone.products.web.pojo.entitys.ProductInfo;

import java.util.List;

/**
 * @Auther: AA
 * @Date: 2023/3/29 19:49
 * @Description: ProductServiceImpl
 * @Version 1.0.0
 */
@Service
@Slf4j
@DubboService
public class ProductServiceImpl implements IProductService {
    @Autowired
    private ProductMapper productMapper;
    @Override
    public int insertProduct(ProductDTO productDTO) {
        ProductInfo productInfo = new ProductInfo();
        BeanUtils.copyProperties(productDTO,productInfo);
        log.debug("原数据【{}】：",productDTO);
        log.debug("执行插入转换后的数据：【{}】",productInfo);
        return productMapper.insert(productInfo);
    }

    @Override
    public int insertBatchProduct(List<ProductDTO> productDTOS) {

        return -1;
    }

    @Override
    public int removeProductById(Long pId) {
        return 0;
    }

    @Override
    public int removeBatchProductByIds(List<Long> pIds) {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductIsDel(1);
        QueryWrapper<ProductInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("product_id",pIds);
        int res = productMapper.update(productInfo,queryWrapper);
        return res;
    }

    @Override
    public int updateProductById(ProductDTO productDTO) {
        ProductInfo newProductInfo = new ProductInfo();
        BeanUtils.copyProperties(productDTO,newProductInfo);
        log.debug("原数据【{}】：",productDTO);
        log.debug("执行将新数据：【{}】更新",newProductInfo);
        return productMapper.updateById(newProductInfo);
    }

    @Override
    public ProductDTO getProductById(Long pId) {
        return null;
    }

    @Override
    public JsonPage<ProductDTO> listProductByPage(Long pageIndex, Long pageSize,String keywords) {
        // page对象中的泛型使用的是接收结果用的对象
        Page<ProductInfo> page = new Page<>(pageIndex,pageSize);
        QueryWrapper<ProductInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("product_name",keywords);
        productMapper.selectPage(page,queryWrapper);
        log.debug("===================页面信息数据=========================");
        log.debug("数据库分页查询记录总数：【{}】",page.getTotal());
        log.debug("数据库分页查询当前页下标：【{}】",page.getCurrent());
        log.debug("数据库分页查询当前页记录数：【{}】",page.getSize());
        log.debug("数据库分页查询总页数：【{}】",page.getPages());
        log.debug("====================页面记录========================");
        log.debug("数据库分页查询结果：【{}】",page.getRecords());
        JsonPage jsonPage = JsonPage.parse(page);
        return jsonPage;
    }
}
