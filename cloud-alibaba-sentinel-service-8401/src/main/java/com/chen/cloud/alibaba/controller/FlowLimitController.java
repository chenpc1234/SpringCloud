package com.chen.cloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.chen.cloud.alibaba.service.SeeHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenpc
 * @version 1.0
 * @since 2021/6/3/06/03  16:29
 */
@RestController
public class FlowLimitController {
    @Autowired
    private SeeHelloService seeHelloService;

    @GetMapping("/testA")
    public String testA(){
        String see = seeHelloService.see();
        return "Test A-------->"+see;
    }
    @GetMapping("/testB")
    public String testB(){
//        try {
//            TimeUnit.MILLISECONDS.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        String see = seeHelloService.see();
        return "Test B-------->"+see;
    }

    @GetMapping("/testKey")
    @SentinelResource(value = "testKey",blockHandler = "fallback_testHotKey")
    public String testHotKey(@RequestParam(value = "p1",required = false) String param1, @RequestParam(value = "p2",required = false) String param2){
        return "param1: "+param1+"param2 : "+param2+"   success";
    }

    /**
     * 服务降级方法
     * @param param1
     * @param param2
     * @param exception
     * @return
     */
    public String fallback_testHotKey(String param1, String param2, BlockException exception){
        return "fail " +exception.getMessage();
    }
}
