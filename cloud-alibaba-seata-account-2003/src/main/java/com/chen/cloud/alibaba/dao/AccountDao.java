package com.chen.cloud.alibaba.dao;

import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @author chenpc
 * @version 1.0
 * @since 2021/6/8/06/08  17:09
 */
public interface AccountDao {
    void decrease(@Param("userId") Long userId, @Param("money") BigDecimal money);
}
