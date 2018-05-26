package com.hsiaoweiyun.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalResource {

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(
            @RequestParam(name = "num1", defaultValue = "0") Long num1,
            @RequestParam(name = "num2", defaultValue = "0") Long num2
    ){
        return String.valueOf(num1 + num2);
    }

}
