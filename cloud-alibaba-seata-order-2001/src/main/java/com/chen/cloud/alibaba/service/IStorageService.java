package com.chen.cloud.alibaba.service;

import com.chen.cloud.alibaba.bean.CommonResult;
import com.chen.cloud.alibaba.service.impl.StorageServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author chenpc
 * @version 1.0
 * @since 2021/5/8/05/08  16:09
 */
@FeignClient(value = "cloud-alibaba-seata-storage",fallback = StorageServiceImpl.class)
public interface IStorageService {
    /**
     *  减少库存方法
     * @param productId  产品ID
     * @param count   减少数量
     * @return 返回信息
     */
    @PostMapping("/storage/decrease")
    CommonResult decrease(@RequestParam(value = "productId") Long productId,
                          @RequestParam(value = "count") Integer count);
}
