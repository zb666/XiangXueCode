package com.xx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.jedis.JedisUtils;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/test")
public class RedisController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping("/redis")
    public String redisTest(){

        String orderKey1 = "order:1";
        String orderKey2 = "order:2";
        String orderKey3 = "order:3";

//        BoundListOperations<String, String> listOperations = stringRedisTemplate.boundListOps("user:1:order");

        BoundHashOperations<String, Object, Object> userHash = stringRedisTemplate.boundHashOps("user:1:order");

        Map<String,String> userMap = new HashMap<>();
        userMap.put("orderId","1");
        userHash.put("money","36");
        userHash.put("orderId:1",userMap);

        userHash.put("user:1:order",userMap);

        Object value = stringRedisTemplate.boundHashOps("user:1:order").get("user:1:order");

        //存放订单信息的Key到队列中
        BoundListOperations<String, String> userList = stringRedisTemplate.boundListOps("user:1:order");
        userList.leftPushAll(orderKey1,orderKey2,orderKey3);

        //新产生一个订单
        BoundHashOperations<String, Object, Object> user4Order = stringRedisTemplate.boundHashOps("order:4");
        user4Order.put("orderId","4");
        user4Order.put("money","40");
        user4Order.put("time","2018");

        BoundHashOperations<String, Object, Object> userOrder = stringRedisTemplate.boundHashOps("order:1:order");

        return "Redis Ok";
    }
}
