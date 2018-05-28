package com.hsiaoweiyun.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloConsumer {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String helloConsumer(){
        return restTemplate.getForEntity("http://CalService/add?num1={1}&num2={2}", String.class, 10, 20).getBody();
    }
    @RequestMapping(value = "/getServiceName", method = RequestMethod.GET)
    public String getServiceName(){
        String s = restTemplate.getForEntity("http://CalService/index", String.class).getBody();
        System.out.println("s: " + s);
        return s;
    }

}
