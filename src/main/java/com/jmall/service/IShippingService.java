package com.jmall.service;

import com.github.pagehelper.PageInfo;
import com.jmall.common.ServerResponse;
import com.jmall.pojo.Shipping;

/**
 * Created by Zheng Jiateng on 2019/1/28.
 */
public interface IShippingService {

    ServerResponse add(Integer userId, Shipping shipping);

    ServerResponse delete(Integer userId, Integer shippingId);

    ServerResponse update(Integer userId, Shipping shipping);

    ServerResponse<Shipping> select(Integer userId, Integer shippingId);

    ServerResponse<PageInfo> list(Integer userId, int pageNum, int pageSize);
}
