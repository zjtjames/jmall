package com.jmall.service.impl;

import com.google.common.collect.Maps;
import com.jmall.common.ServerResponse;
import com.jmall.dao.ShippingMapper;
import com.jmall.pojo.Shipping;
import com.jmall.service.IShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

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
        // 与前端的约定是插入之后立刻拿到主键id
        if (rowCount > 0) {
            Map resultMap = Maps.newHashMap();
            resultMap.put("shippingId", shipping.getId());
            return ServerResponse.createBySuccess("新建地址成功", resultMap);
        }
        return ServerResponse.createByErrorMessage("新建地址失败");
    }

    public ServerResponse delete(Integer userId, Integer shippingId) {

    }
}

