package com.hsiaoweiyun.vo;

import lombok.Data;

@Data
public class InstancesVo {

    private String serviceId;
    private String host;
    private int port;
    private String url;
    private boolean isSecure;

    public InstancesVo() {
    }

    public InstancesVo(String serviceId, String host, int port, String url, boolean isSecure) {
        this.serviceId = serviceId;
        this.host = host;
        this.port = port;
        this.url = url;
        this.isSecure = isSecure;
    }
}
