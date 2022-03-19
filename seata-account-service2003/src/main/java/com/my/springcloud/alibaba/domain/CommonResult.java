package com.my.springcloud.alibaba.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ZDL
 * @create 2022-03-18 16:53
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult<T> {

    private Integer id;
    private String message;
    private T  data;

    public CommonResult(Integer code, String message){
        this(code,message,null);
    }

}
