package com.my.springcloud.alibaba.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @author ZDL
 * @create 2022-03-18 17:11
 */
@FeignClient(value = "seata-account-service")
public interface AccountService {

    @PostMapping("/account/decrease")
    void decrease(@RequestParam("userId") Long userId,
                  @RequestParam("money") BigDecimal money);
}
