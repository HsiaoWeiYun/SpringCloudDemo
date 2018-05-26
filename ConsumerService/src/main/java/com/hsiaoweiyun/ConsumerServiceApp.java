package com.hsiaoweiyun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = {"com.hsiaoweiyun.resource", "com.hsiaoweiyun.config"})
public class ConsumerServiceApp
{
    public static void main( String[] args )
    {
        SpringApplication.run(ConsumerServiceApp.class, args);
    }
}
