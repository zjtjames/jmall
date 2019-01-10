/**
 * created by Zheng Jiateng on 2019/1/10.
 */
package com.jmall.controller.portal;

import com.jmall.common.ServerResponse;
import com.jmall.service.IProductService;
import com.jmall.service.IUserService;
import com.jmall.vo.ProductDetailVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    IUserService iUserService;

    @Autowired
    IProductService iProductService;

    //产品详情
    @RequestMapping("detail.do")
    @ResponseBody //自动通过springmvc的jackson插件自动将返回值序列化为json
    public ServerResponse<ProductDetailVo> detail(Integer productId) {
        return iProductService.getProductDetail(productId);
    }
}
