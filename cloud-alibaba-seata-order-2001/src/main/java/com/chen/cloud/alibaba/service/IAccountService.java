package com.chen.cloud.alibaba.service;

import com.chen.cloud.alibaba.bean.CommonResult;
import com.chen.cloud.alibaba.service.impl.AccountServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author chenpc
 * @version 1.0
 * @since 2021/5/8/05/08  16:09
 */
@FeignClient(value = "cloud-alibaba-seata-account",fallback = AccountServiceImpl.class)
public interface IAccountService {
    /**
     *  减少库存方法
     * @param userId  用户ID
     * @param money   需要扣的钱数
     * @return 返回信息
     */
    @PostMapping("/account/decrease")
    CommonResult decrease(@RequestParam(value = "userId") Long userId,
                          @RequestParam(value = "money") Long money);
}
