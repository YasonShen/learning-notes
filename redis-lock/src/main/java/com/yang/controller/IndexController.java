package com.yang.controller;

import org.redisson.Redisson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author shenqiuyang3
 * @date 2021/2/14 22:06
 * @Description
 */
@RestController
@RequestMapping("redis")
public class IndexController {

    @Autowired
    private Redisson redisson;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    private static final String lockKey = "lockKey";

    @RequestMapping("/deduct_stock")
    public String deductStock() {
        try {
            Boolean result = stringRedisTemplate.opsForValue().setIfAbsent(lockKey, "zhuge"); //jedis.setnx(key,value);
            stringRedisTemplate.expire(lockKey, 10, TimeUnit.SECONDS);

            if (!result) {
                return "error_code 当前系统繁忙";
            }

            int stock = Integer.parseInt(stringRedisTemplate.opsForValue().get("stock"));
            if (stock > 0) {
                int realLock = stock - 1;
                stringRedisTemplate.opsForValue().set("stock", realLock + "");
                System.out.println("扣减成功，剩余库存：" + realLock);
            } else {
                System.out.println("扣减失败，库存不足");
            }
        }finally {
            stringRedisTemplate.delete(lockKey);
        }

//        stringRedisTemplate.delete(lockKey);

        return "deductStock";
    }
}
