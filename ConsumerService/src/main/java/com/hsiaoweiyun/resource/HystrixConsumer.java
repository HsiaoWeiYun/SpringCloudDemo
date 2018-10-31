package com.hsiaoweiyun.resource;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/test/hystrix")
public class HystrixConsumer {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/randomSleep", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "timeoutFallback", commandKey = "testHystrixByRandomSleep")
    public String testHystrixByRandomSleep(){
        return restTemplate.getForEntity("http://CalService/hystrix/randomSleep", String.class).getBody();
    }



    public String timeoutFallback(){
        return "Time Out";
    }


}
