/**
 * created by Zheng Jiateng on 2018/12/28.
 */
package com.jmall.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jmall.common.ResponseCode;
import com.jmall.common.ServerResponse;
import com.jmall.dao.CategoryMapper;
import com.jmall.dao.ProductMapper;
import com.jmall.pojo.Category;
import com.jmall.pojo.Product;
import com.jmall.service.IProductService;
import com.jmall.util.DateTimeUtil;
import com.jmall.util.PropertiesUtil;
import com.jmall.vo.ProductDetailVo;
import com.jmall.vo.ProductListVo;
import net.sf.jsqlparser.schema.Server;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service("iProductService") //这里实际上不用命名 因为@Autowired是根据类型查找的
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private CategoryMapper categoryMapper;

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

    public ServerResponse setSaleStatus(Integer productId, Integer status) {
        if (productId == null || status == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDescription());
        }
        Product product = new Product();
        product.setId(productId);
        product.setStatus(status);
        int rowCount = productMapper.updateByPrimaryKeySelective(product);
        if (rowCount > 0) {
            return ServerResponse.createBySuccessMessage("修改产品销售状态成功");
        }
        return ServerResponse.createByErrorMessage("修改产品销售状态失败");
    }

    public ServerResponse<ProductDetailVo> manageProductDetail(Integer productId) {
        if (productId == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDescription());
        }
        Product product = productMapper.selectByPrimaryKey(productId);
        if (product == null) {
            ServerResponse.createByErrorMessage("产品不存在");
        }
        // 简单版：返回vo对象--value object
        // 复杂版：pojo->bo(business object)->vo(view object)
        ProductDetailVo productDetailVo = assembleProductDetailVo(product);
        return ServerResponse.createBySuccess(productDetailVo);
    }

    // 用Product对象装配出ProductDetailVo对象
    private ProductDetailVo assembleProductDetailVo(Product product) {
        ProductDetailVo productDetailVo = new ProductDetailVo();
        productDetailVo.setId(product.getId());
        productDetailVo.setCategoryId(product.getCategoryId());
        productDetailVo.setName(product.getName());
        productDetailVo.setSubtitle(product.getSubtitle());
        productDetailVo.setMainImage(product.getMainImage());
        productDetailVo.setSubImages(product.getSubImages());
        productDetailVo.setDetail(product.getDetail());
        productDetailVo.setPrice(product.getPrice());
        productDetailVo.setStock(product.getStock());
        productDetailVo.setStatus(product.getStatus());

        //imageHost
        productDetailVo.setImageHost(PropertiesUtil.getProperty("ftp.server.http.prefix", "http://img.happyjmall.com/"));

        //parentCategoryId
        Category category = categoryMapper.selectByPrimaryKey(product.getCategoryId());
        if (category == null) {
            productDetailVo.setParentCategoryId(0); // 默认根节点
        } else {
            productDetailVo.setParentCategoryId(category.getParentId());
        }

        //createTime
        productDetailVo.setCreateTime(DateTimeUtil.dateToStr(product.getCreateTime()));
        //updateTime
        productDetailVo.setUpdateTime(DateTimeUtil.dateToStr(product.getUpdateTime()));

        return productDetailVo;
    }

    public ServerResponse<PageInfo> getProductList(Integer pageNum, Integer pageSize) {
        // pagehelper通过aop的方式，在执行sql的时候，在sql的后面写上分页处理，mybatis pager就会监听到这个切面，就通过aop把分页需要的sql再执行一遍
        // startPage--start 开始分页
        PageHelper.startPage(pageNum, pageSize);
        //填充自己的sql查询逻辑
        List<Product> productList = productMapper.selectList();
        List<ProductListVo> productListVoList = new ArrayList<>();
        for (Product productItem : productList) {
            productListVoList.add(assembleProductListVo(productItem));
        }
        //pageHelper-收尾
        // 先用productList进行分页
        PageInfo pageResult = new PageInfo(productList);
        // 再重置分页结果中的List为productListVoList
        pageResult.setList(productListVoList);
        return ServerResponse.createBySuccess(pageResult);
    }

    // 用Product对象装配出ProductListVo对象
    private ProductListVo assembleProductListVo(Product product) {
        ProductListVo productListVo = new ProductListVo();
        productListVo.setId(product.getId());
        productListVo.setCategoryId(product.getCategoryId());
        productListVo.setName(product.getName());
        productListVo.setSubtitle(product.getSubtitle());
        productListVo.setMainImage(product.getMainImage());
        productListVo.setPrice(product.getPrice());
        productListVo.setStatus(product.getStatus());
        productListVo.setImageHost(PropertiesUtil.getProperty("ftp.server.http.prefix", "http://img.happyjmall.com/"));
        return productListVo;
    }
}
