package os.g.zone.products.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import os.g.zone.commons.consts.ReplyCode;
import os.g.zone.commons.results.JsonPage;
import os.g.zone.commons.results.JsonResult;
import os.g.zone.products.api.dto.ProductDTO;
import os.g.zone.products.api.service.IProductService;
import os.g.zone.products.web.pojo.vo.ProductVO;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * 产品服务控制器
 * @Auther: AA
 * @Date: 2023/3/29 15:46
 * @Version 1.0.0
 */
@RestController
@Slf4j
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @PostMapping("/save")
    public JsonResult<Void> saveProduct(ProductVO productVO){
        ProductDTO param = new ProductDTO();
        BeanUtils.copyProperties(productVO,param);
        param.setProductCreateTime(new Timestamp(System.currentTimeMillis()));
        int res = iProductService.insertProduct(param);
        if(res != 1){
            return JsonResult.failed(ReplyCode.RES_ERROR,"新增产品失败！");
        }
        return JsonResult.success();
    }

    @PostMapping("/update")
    public JsonResult<Void> updateProduct(ProductVO productVO){
        ProductDTO param = new ProductDTO();
        BeanUtils.copyProperties(productVO,param);
        param.setProductModifiedTime(new Timestamp(System.currentTimeMillis()));
        int res = iProductService.updateProductById(param);
        if(res != 1){
            return JsonResult.failed(ReplyCode.RES_ERROR,"修改产品失败！");
        }
        return JsonResult.success();
    }

    @GetMapping("/query/{pageIndex}/{pageSize}")
    public JsonResult getAllProduct(
            @PathVariable("pageIndex") Long pageIndex,
            @PathVariable("pageSize") Long pageSize,String input){

        JsonPage<ProductDTO> data = iProductService.listProductByPage(
                pageIndex,pageSize,input);

        return JsonResult.success(data);
    }
    @GetMapping("/del")
    public JsonResult getAllProduct(String ids){
        log.debug(ids);
        String[] params = ids.split(",");
        List<Long> longList = new ArrayList<>();
        for (int i = 0; i < params.length; i++) {
            longList.add(Long.valueOf(params[i]));
        }
        iProductService.removeBatchProductByIds(longList);

        return JsonResult.success();
    }
}
