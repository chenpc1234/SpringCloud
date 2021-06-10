package com.chen.cloud.alibaba.service.impl;

import com.chen.cloud.alibaba.bean.CommonResult;
import com.chen.cloud.alibaba.service.IAccountService;
import org.springframework.stereotype.Component;

/**
 * @author chenpc
 * @version 1.0
 * @since 2021/5/8/05/08  16:10
 */
@Component
public class AccountServiceImpl implements IAccountService {
    @Override
    public CommonResult decrease(Long userId, Long money) {
        return new CommonResult(500, "账户服务调用失败-->请重试");
    }
}
