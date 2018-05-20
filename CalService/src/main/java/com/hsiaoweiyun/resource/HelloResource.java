package com.hsiaoweiyun.resource;

import com.hsiaoweiyun.vo.InstancesVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HelloResource {

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "/index", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<InstancesVo> index(){
        List<InstancesVo> instancesVoList = new ArrayList<>();
        List<String> serviceList = discoveryClient.getServices();
        for(String s : serviceList){
            for(ServiceInstance serviceInstance : discoveryClient.getInstances(s)){
                instancesVoList.add(new InstancesVo(serviceInstance.getServiceId(), serviceInstance.getHost(), serviceInstance.getPort(), serviceInstance.getUri().toString(), serviceInstance.isSecure()));
            }
        }
        return instancesVoList;
    }

}
