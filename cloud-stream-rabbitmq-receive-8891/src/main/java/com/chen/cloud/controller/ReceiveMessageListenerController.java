package com.chen.cloud.controller;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenpc
 * @version 1.0
 * @since 2021/5/5/05/05  22:28
 */
@Component
@EnableBinding(Sink.class)
public class ReceiveMessageListenerController {

    @StreamListener(Sink.INPUT)
    public void input(Message<String> message){
        System.out.println("Receiver 1号 接受到消息" + message.getPayload());
    }

}
