package com.jmall.service;

import com.jmall.common.ServerResponse;

public interface ICategoryService {
    ServerResponse addCategory(String categoryName, Integer parentId); // 添加品类

    ServerResponse updateCategoryName(Integer categoryId, String categoryName); // 更新品类名
}
