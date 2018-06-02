package com.hsiaoweiyun.config;


import com.netflix.loadbalancer.*;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RibbonConfig {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    public IRule iRule(){
        //輪詢, 嘗試10次選擇不到server則報警告
        //return new RoundRobinRule();

        //隨機存取
        //return new RandomRule();

        //server沒活著時會自動retry
        //return new RetryRule(new RoundRobinRule());

        //後台執行緒從status內取出response算出weight, weight越低被選擇的能性就越低 剛開始運行還沒有status時使用RoundRobinRule
        //return new WeightedResponseTimeRule();

        //從可用的server清單內選一個併發數較少的
        //return new BestAvailableRule();

        //輪詢方式選擇server, 若選擇的server未滿足條件則輪詢下個server, 否則直接使用.
        //條件為檢查server併發數 (niws.loadbalancer.availabilityFilteringRule.ActiveConnectionsLimit)
        return new AvailabilityFilteringRule();
    }

}
