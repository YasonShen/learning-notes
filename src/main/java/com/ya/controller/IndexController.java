package com.ya.controller;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.Date;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class IndexController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private Redisson redisson;

    public String deductStock(){
        String lockKey = "lockKey";
        String clientId = UUID.randomUUID().toString();

        RLock lock = redisson.getLock(lockKey);

        try {

//            Boolean result = stringRedisTemplate.opsForValue().setIfAbsent(lockKey, clientId, 10, TimeUnit.SECONDS);
//            if (!result){
//                return "error_code";
//            }

            lock.lock();

            int stock = Integer.parseInt(stringRedisTemplate.opsForValue().get("stock"));
            if (stock > 0){
                stock--;
                stringRedisTemplate.opsForValue().set("stock", String.valueOf(stock));
                System.out.println("扣减成功，剩余库存" + stock);
            }else{
                System.out.println("扣减失败，库存不足");
            }
        }finally {

            lock.unlock();
//            if (clientId.equals(stringRedisTemplate.opsForValue().get(clientId))){
//                stringRedisTemplate.delete(lockKey);
//            }
        }

        return "end";
    }
}
