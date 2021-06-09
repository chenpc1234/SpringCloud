package com.chen.cloud.alibaba.controller;

import com.chen.cloud.alibaba.bean.CommonResult;
import com.chen.cloud.alibaba.bean.Order;
import com.chen.cloud.alibaba.service.impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenpc
 * @version 1.0
 * @since 2021/5/8/05/08  16:30
 */
@RestController
public class OrderController {
    @Autowired
    private OrderServiceImpl orderService;

    @GetMapping("/create/order")
    public CommonResult<Order> create(Order order){
        orderService.createOrder(order);
        return new CommonResult<>(200, "成功");
    }
}
