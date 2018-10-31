package com.hsiaoweiyun.controller;


import com.test.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {

    @Autowired
    RedisUtils redisUtils;

    @GetMapping("/test")
    public String test(){
        //return String.valueOf(redisUtils.test());

        return redisUtils.test2();

    }


}
