package com.chen.cloud.alibaba.service;

/**
 * @author chenpc
 * @version 1.0
 * @since 2021/6/8/06/08  16:48
 */
public interface IStorageService {
    /**
     * 扣减库存
     * @param productId productId
     * @param  count count
     */
    void decrease(Long productId, Integer count);
}
