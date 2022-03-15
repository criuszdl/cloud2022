package com.my.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/** 区别就是链路流控会对整条链路进行限流，直接流控只会对当前资源进行限流
 * @author ZDL
 * @create 2022-03-14 10:34
 */
@RestController
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA(){
        return "========testA";
    }


    @GetMapping("/testB")
    public String testB(){
        return "========testB";
    }

    @GetMapping("/testD")
    public String testD(){
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int i = 10/0;
        return "========testD";
    }

    @GetMapping("/testE")
    public String testE()
    {
        int age = 10/0;
        return "------testE 测试异常比例";
    }

    @GetMapping("/testhk")
    @SentinelResource(value = "testhk",blockHandler = "deal_testhk")
    public String testHotkey(@RequestParam(value = "p1",required = false) String p1,
                             @RequestParam(value = "p2",required = false) String p2){
        return "---------test Hotkey===";
    }

    public String deal_testhk(String p1, String p2, BlockException exception){
        return "block_default_hander,热点规则限流。";
    }

}
