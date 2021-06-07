package com.chen.cloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.chen.cloud.alibaba.service.GlobalBlockHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenpc
 * @version 1.0
 * @since 2021/6/7/06/07  10:12
 */
@RestController
public class RateLimitController {
    @GetMapping("/testCCC")
    @SentinelResource(value = "ccc",blockHandler = "default_blockHandler")
    public String testA(){
        return "Test testCCC-------->";
    }
    @GetMapping("/testDDD")
    @SentinelResource(value = "ddd",
            blockHandlerClass = GlobalBlockHandler.class,
            blockHandler = "blockHandler")
    public String testB(){
        return "Test testDDD-------->";
    }


    public String default_blockHandler(BlockException blockException){
        return "fail ";
    }
}
