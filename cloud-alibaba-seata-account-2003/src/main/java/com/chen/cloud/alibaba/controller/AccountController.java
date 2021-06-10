package com.chen.cloud.alibaba.controller;

import com.chen.cloud.alibaba.bean.CommonResult;
import com.chen.cloud.alibaba.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenpc
 * @version 1.0
 * @since 2021/6/8/06/08  17:12
 */
@RestController
public class AccountController {

    @Autowired
    private IAccountService accountService;
    @PostMapping("/account/decrease")
    CommonResult decrease(@RequestParam(value = "userId") Long userId,
                          @RequestParam(value = "money") Long money){
//        try {
//            TimeUnit.SECONDS.sleep(5);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        accountService.decrease(userId,money);
        return new CommonResult<>(200, "成功");
    }
}
