package com.hsiaoweiyun;

import com.hsiaoweiyun.config.RedisProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan({"com.hsiaoweiyun.resource", "com.hsiaoweiyun.config"})
@EnableConfigurationProperties(RedisProperties.class)
public class CalServiceApp {
    public static void main(String[] args) {
        SpringApplication.run(CalServiceApp.class, args);
    }
}
