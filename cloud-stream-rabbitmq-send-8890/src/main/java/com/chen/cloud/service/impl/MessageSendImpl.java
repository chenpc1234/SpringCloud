package com.chen.cloud.service.impl;

import com.chen.cloud.service.IMessageSend;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;


/**
 * @author chenpc
 * @version 1.0
 * @since 2021/5/5/05/05  20:28
 */
@EnableBinding(Source.class)
public class MessageSendImpl implements IMessageSend {

    @Resource
    private MessageChannel output;
    @Override
    public String Send() {
        String s = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(s).build());
        System.out.println("output ok "+s);
        return null;
    }
}
