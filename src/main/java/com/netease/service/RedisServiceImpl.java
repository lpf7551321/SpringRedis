package com.netease.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * Created by hz-lpf on 16-5-25.
 */
public class RedisServiceImpl {
    private RedisTemplate<String,String> redisTemplate;



    public boolean add(final String key,final String value) {
        redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection redisConnection) throws DataAccessException {
                byte[] keys = getSerializer().serialize(key);
                byte[] values = getSerializer().serialize(value);
                return redisConnection.setNX(keys,values);
            }
        });
        return true;
    }


    private RedisSerializer<String> getSerializer(){
        return  redisTemplate.getStringSerializer();
    }

    @Autowired
    @Qualifier("jedisTemplate")
    public void setRedisTemplate(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
}
