package os.g.zone.products.web.mappers;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import os.g.zone.products.web.pojo.bo.ProductInfoBO;
import os.g.zone.products.web.pojo.entitys.ProductInfo;

/**
 * 使用mybatis的BaseMapper可以省掉编写sql及xml文件的麻烦，
 * 但是也可以自定义方法
 * 用法与myvatis一致
 */
public interface ProductMapper extends BaseMapper<ProductInfo> {
    Page<ProductInfoBO> listAllProductByPage(@Param("page")Page<ProductInfoBO> page);
}
