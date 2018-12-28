/**
 * created by Zheng Jiateng on 2018/12/28.
 */
package com.jmall.service.impl;

import com.jmall.common.ServerResponse;
import com.jmall.pojo.Product;
import com.jmall.service.IProductService;
import org.springframework.stereotype.Service;

@Service("iProductService") //这里实际上不用命名 因为@Autowired是根据类型查找的
public class ProductServiceImpl implements IProductService {

    public ServerResponse saveOrUpdateProduct(Product product) {
        if (product != null) {

        }
        return ServerResponse.createByErrorMessage("新增或更新产品参数不正确");
    }

}
