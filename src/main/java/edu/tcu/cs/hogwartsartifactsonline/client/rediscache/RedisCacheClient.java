package edu.tcu.cs.hogwartsartifactsonline.client.rediscache;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisCacheClient {

    private final StringRedisTemplate stringRedisTemplate;

    public RedisCacheClient(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    public void delete(String key) {
        this.stringRedisTemplate.delete(key);
    }

}
