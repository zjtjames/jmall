package com.jmall.service;

import com.jmall.common.ServerResponse;
import com.jmall.vo.CartVo;

public interface ICartService {

    ServerResponse<CartVo> add(Integer userId, Integer productId, Integer count);
}
