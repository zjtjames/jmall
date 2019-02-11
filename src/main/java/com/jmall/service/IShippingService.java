package com.jmall.service;

import com.jmall.common.ServerResponse;
import com.jmall.pojo.Shipping;

/**
 * Created by Zheng Jiateng on 2019/1/28.
 */
public interface IShippingService {

    ServerResponse add(Integer userId, Shipping shipping);
}
