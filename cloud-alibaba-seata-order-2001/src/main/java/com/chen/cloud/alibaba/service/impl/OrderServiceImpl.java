package com.chen.cloud.alibaba.service.impl;

import com.chen.cloud.alibaba.bean.Order;
import com.chen.cloud.alibaba.dao.OrderDao;
import com.chen.cloud.alibaba.service.IAccountService;
import com.chen.cloud.alibaba.service.IOrderService;
import com.chen.cloud.alibaba.service.IStorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author chenpc
 * @version 1.0
 * @since 2021/5/8/05/08  16:03
 */
@Service
@Slf4j
public class OrderServiceImpl implements IOrderService {
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private IAccountService accountService;
    @Autowired
    private IStorageService storageService;

    public void createOrder(Order order){
        log.info("No1--->开始创建订单 初始状态未付款");
        orderDao.insert(order);
        log.info("No2--->开始减少库存");
        storageService.decrease(order.getProductId(), order.getCount());
        log.info("No3--->开始减少账户余额");
        accountService.decrease(order.getUserId(), order.getMoney());
        log.info("No4--->修改订单状态 已完成");
        orderDao.updateByUserIdStatus(order.getUserId(), order.getStatus());
        log.info("No5--->订单完成");
    }

}
