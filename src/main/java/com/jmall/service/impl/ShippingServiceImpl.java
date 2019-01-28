package com.jmall.service.impl;

import com.jmall.common.ServerResponse;
import com.jmall.dao.ShippingMapper;
import com.jmall.pojo.Shipping;
import com.jmall.service.IShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Zheng Jiateng on 2019/1/28.
 */

@Service("iShippingService")
public class ShippingServiceImpl implements IShippingService {

    @Autowired
    private ShippingMapper shippingMapper;

    public ServerResponse add(Integer userId, Shipping shipping) {
        shipping.setUserId(userId);
        int rowCount = shippingMapper.insert(shipping);
    }
}

