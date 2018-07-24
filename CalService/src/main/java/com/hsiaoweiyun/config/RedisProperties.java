package com.hsiaoweiyun.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "redis")
@Component
public class RedisProperties {

    private String host;
    private int port;
    private Pool pool;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public static class Pool {
        private int maxTotal;
        private int maxIdle;
        private int minIdle;

        public int getMaxTotal() {
            return maxTotal;
        }

        public void setMaxTotal(int maxTotal) {
            this.maxTotal = maxTotal;
        }

        public int getMaxIdle() {
            return maxIdle;
        }

        public void setMaxIdle(int maxIdle) {
            this.maxIdle = maxIdle;
        }

        public int getMinIdle() {
            return minIdle;
        }

        public void setMinIdle(int minIdle) {
            this.minIdle = minIdle;
        }
    }

    public Pool getPool() {
        return pool;
    }

    public void setPool(Pool pool) {
        this.pool = pool;
    }
}
