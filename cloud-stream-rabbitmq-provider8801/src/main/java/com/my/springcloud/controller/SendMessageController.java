package com.my.springcloud.controller;

import com.my.springcloud.service.IMessageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author ZDL
 * @create 2022-03-08 15:38
 */

@RestController
public class SendMessageController {

    @Resource
    private IMessageService iMessageService;

    @GetMapping(value = "/sendMessage")
    public String sendMessage(){
        return iMessageService.send();
    }

}
