package com.chen.cloud.alibaba.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chen.cloud.alibaba.bean.Order;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author chenpc
 * @version 1.0
 * @since 2021/5/8/05/08  15:44
 */
@Mapper
public interface OrderDao extends BaseMapper<Order> {
    /**
     * 根据用户名修改订单状态
     * @param userId 用户名
     * @param status 订单状态
     */
    void updateByUserIdStatus(Long userId,Integer status);
}
