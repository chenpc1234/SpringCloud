package com.chen.cloud.alibaba.controller;

import com.chen.cloud.alibaba.bean.CommonResult;
import com.chen.cloud.alibaba.service.IStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenpc
 * @version 1.0
 * @since 2021/6/8/06/08  16:46
 */
@RestController
public class StorageController {

    @Autowired
    private IStorageService storageService;

    /**
     *  减少库存方法
     * @param productId  产品ID
     * @param count   减少数量
     * @return 返回信息
     */
    @PostMapping("/storage/decrease")
    CommonResult decrease(@RequestParam(value = "productId") Long productId,
                          @RequestParam(value = "count") Integer count){
        storageService.decrease(productId,count);
        return new CommonResult<>(200, "成功");
    }
}
