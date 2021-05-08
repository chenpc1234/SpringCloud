package com.chen.cloud.alibaba.service.impl;

import com.chen.cloud.alibaba.bean.CommonResult;
import com.chen.cloud.alibaba.service.IStorageService;
import org.springframework.stereotype.Component;

/**
 * @author chenpc
 * @version 1.0
 * @since 2021/5/8/05/08  16:10
 */
@Component
public class StorageServiceImpl implements IStorageService {
    @Override
    public CommonResult decrease(Long productId, Integer count) {
        return new CommonResult(500, "减少库存服务请求失败->请重试");
    }
}
