package com.chen.cloud.alibaba.service;

import com.chen.cloud.alibaba.bean.Order;

/**
 * @author chenpc
 * @version 1.0
 * @since 2021/5/8/05/08  16:03
 */
public interface IOrderService {
    /**
     * 订单创建
     * @param order 订单
     */
    public void createOrder(Order order);
}
