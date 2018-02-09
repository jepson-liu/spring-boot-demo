package cn.liuzhiping.intergration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.Date;

@RestController
@RequestMapping("redis")
public class RedisController {
    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping
    public String get() {
        ValueOperations<Serializable, String> operations = redisTemplate.opsForValue();
        operations.set("redis_test_key", "redis_test_value");
        return operations.get("redis_test_key")+"  "+new Date();
    }
}

