/**
 * created by Zheng Jiateng on 2018/12/28.
 */
package com.jmall.service.impl;

import com.jmall.common.ServerResponse;
import com.jmall.dao.ProductMapper;
import com.jmall.pojo.Product;
import com.jmall.service.IProductService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("iProductService") //这里实际上不用命名 因为@Autowired是根据类型查找的
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductMapper productMapper;

    public ServerResponse saveOrUpdateProduct(Product product) {
        if (product != null) {
            if (StringUtils.isNotBlank(product.getSubImages())) {
                String[] subImageArray = product.getSubImages().split(",");
                if (subImageArray.length > 0) {
                    product.setMainImage(subImageArray[0]);
                }
            }

            if (product.getId() != null) {
                int rowCount = productMapper.updateByPrimaryKey(product);
                return ServerResponse.createBySuccessMessage("更新产品成功");
            } else {
                productMapper.insert(product);
                return ServerResponse.createBySuccessMessage("新增产品成功");
            }
        }
        return ServerResponse.createByErrorMessage("新增或更新产品参数不正确");
    }


}
