package com.jmall.service;

import com.jmall.common.ServerResponse;
import com.jmall.pojo.Product;

public interface IProductService {
    ServerResponse saveOrUpdateProduct(Product product);
}
