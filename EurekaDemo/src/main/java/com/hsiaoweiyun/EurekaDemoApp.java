package com.hsiaoweiyun;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
@Slf4j
public class EurekaDemoApp {
    public static void main(String[] args) {
        log.debug("##################################################################################sdsdsd");
        SpringApplication.run(EurekaDemoApp.class, args);
    }
}
