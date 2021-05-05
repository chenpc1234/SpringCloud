package com.chen.cloud.controller;

import com.chen.cloud.service.IMessageSend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author chenpc
 * @version 1.0
 * @since 2021/5/5/05/05  20:34
 */
@RestController
public class SendMessageController {

    @Resource
    private IMessageSend iMessageSend;

    @GetMapping("/testSend")
    public String send(){
        iMessageSend.Send();
        return null;
    }
}
