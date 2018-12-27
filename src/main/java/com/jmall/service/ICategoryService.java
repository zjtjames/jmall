package com.jmall.service;

import com.jmall.common.ServerResponse;
import com.jmall.pojo.Category;

import java.util.List;

public interface ICategoryService {
    ServerResponse addCategory(String categoryName, Integer parentId); // 添加品类

    ServerResponse updateCategoryName(Integer categoryId, String categoryName); // 更新品类名

    ServerResponse<List<Category>> getChildrenParallelCategory(Integer categoryId); // 获取品类子节点 平级 不递归

    public ServerResponse getCategoryAndChildrenById(Integer categoryId); //递归查询本节点及孩子节点的id
}
