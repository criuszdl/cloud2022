package com.my.springcloud.service.impl;

import com.my.springcloud.service.IMessageService;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author ZDL
 * @create 2022-03-07 22:46
 */

/**
 * 定义消息推送通道
 */
@EnableBinding(Source.class)
public class MessageServiceImpl implements IMessageService {

    /**
     * 消息的发送管道
     */
    @Resource
    private MessageChannel output;

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("***********serial:"+serial);
        return serial;
    }

}
