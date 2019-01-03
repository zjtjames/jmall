package com.jmall.service;

import com.github.pagehelper.PageInfo;
import com.jmall.common.ServerResponse;
import com.jmall.pojo.Product;
import com.jmall.vo.ProductDetailVo;

public interface IProductService {
    ServerResponse saveOrUpdateProduct(Product product); // 新增或更新产品

    ServerResponse setSaleStatus(Integer productId, Integer status); // 产品上下架

    ServerResponse<ProductDetailVo> manageProductDetail(Integer productId); // 产品详情

    public ServerResponse<PageInfo> getProductList(Integer pageNum, Integer pageSize); //产品list 分页
}
