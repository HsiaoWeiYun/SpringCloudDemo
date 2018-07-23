package com.hsiaoweiyun.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalResource {

    @Autowired
    RedisTemplate redisTemplate;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(
            @RequestParam(name = "num1", defaultValue = "0") Long num1,
            @RequestParam(name = "num2", defaultValue = "0") Long num2
    ){
        return String.valueOf(num1 + num2);
    }


    @RequestMapping(value = "/addInRedis", method = RequestMethod.GET)
    public String addInRedis(
            @RequestParam(name = "key") String key,
            @RequestParam(name = "amount", defaultValue = "0") Long amount
    ){
        Long dataAfterCal = redisTemplate.opsForValue().increment(key, amount);
        return String.valueOf(dataAfterCal);
    }

}
