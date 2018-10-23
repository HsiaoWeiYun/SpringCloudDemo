package com.hsiaoweiyun;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaServer
@ComponentScan(basePackages = "com.hsiaoweiyun.*")
@Slf4j
public class EurekaDemoApp {
    public static void main(String[] args) {
        SpringApplication.run(EurekaDemoApp.class, args);
    }
}
