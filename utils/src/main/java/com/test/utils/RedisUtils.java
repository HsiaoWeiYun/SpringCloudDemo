package com.test.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisCommands;

@Component
public class RedisUtils {

    private RedisTemplate redisTemplate;

    @Autowired
    public void init(@Qualifier("redisTemplate") RedisTemplate template){
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        redisTemplate = template;
    }


    public boolean test(){
        return redisTemplate.opsForValue().setIfAbsent("abc","sdfgsg");
    }


    public String test2(){
        String a = (String) redisTemplate.execute(new RedisCallback() {
            @Override
            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
                JedisCommands commands = (JedisCommands) redisConnection.getNativeConnection();
                return commands.set("abc", "sdfgsg-dsgsdgsdgsdgsd", "NX", "PX", 10000);
            }
        });
        return a;
    }



}
