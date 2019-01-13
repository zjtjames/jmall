package com.jmall.service;

import com.github.pagehelper.PageInfo;
import com.jmall.common.ServerResponse;
import com.jmall.pojo.Product;
import com.jmall.vo.ProductDetailVo;

public interface IProductService {
    ServerResponse saveOrUpdateProduct(Product product); // 新增或更新产品

    ServerResponse setSaleStatus(Integer productId, Integer status); // 产品上下架

    ServerResponse<ProductDetailVo> manageProductDetail(Integer productId); // 产品详情

    ServerResponse<PageInfo> getProductList(Integer pageNum, Integer pageSize); //产品list 分页

    ServerResponse<PageInfo> searchProduct(String productName, Integer productId, Integer pageNum, Integer pageSize); //产品搜索

    ServerResponse<ProductDetailVo> getProductDetail(Integer productId); //用户版的产品详情

    // 用户版的产品搜索及动态排序 categoryId
    ServerResponse<PageInfo> getProductByKeywordCategory(String keyword, Integer categoryId, int pageNum, int pageSize, String orderBy);

}
