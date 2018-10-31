package com.hsiaoweiyun.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("/hystrix")
public class HystrixResource {


    @RequestMapping(value = "/randomSleep", method = RequestMethod.GET)
    public String testHystrixByRandomSleep() throws InterruptedException {
        int sleepTime = new Random().nextInt(5000);
        Thread.sleep(sleepTime);
        return "Success";
    }

}
