package com.chen.cloud.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chen.cloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author chenpc
 * @version 1.0
 * @since 2021/4/19/04/19  15:28
 */
@Mapper
public interface PaymentDao extends BaseMapper<Payment> {
    /**
     * 查询 queryPayment
     * @param id 查询主键
     * @return Payment
     */
    public Payment queryPayment(Long id);
}
