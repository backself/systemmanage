package os.g.zone.products.api.service;


import os.g.zone.commons.results.JsonPage;
import os.g.zone.products.api.dto.ProductDTO;

import java.util.List;

public interface IProductService {

    int insertProduct(ProductDTO productDTO);
    int insertBatchProduct(List<ProductDTO> productDTOS);
    int removeProductById(Long pId);
    int removeBatchProductByIds(List<Long> pIds);
    int updateProductById(ProductDTO productDTO);
    ProductDTO getProductById(Long pId);
    JsonPage<ProductDTO> listProductByPage(Long pageIndex, Long pageSize, String keywords);
}
