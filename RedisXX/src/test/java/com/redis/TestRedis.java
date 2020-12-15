package com.redis;


import com.xx.redis.RedisApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.jedis.JedisUtils;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RedisApplication.class)
public class TestRedis {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void testRedis(){

        String orderKey1 = "order:1";
        String orderKey2 = "order:2";
        String orderKey3 = "order:3";

        HashOperations<String, String, String> stringObjectObjectHashOperations = stringRedisTemplate.opsForHash();
//        stringObjectObjectHashOperations.put("user:1:order","orderId","1");
//        stringObjectObjectHashOperations.put("user:1:order","money","36");

        //用户订单的操作
        Map<String,String> userMap = new HashMap<>();
        userMap.put("orderId","1");
        userMap.put("money","36");
        userMap.put("time","2018-01-01");
        stringObjectObjectHashOperations.putAll("user:1:order:map",userMap);

        //存放订单信息的Key到队列中
        BoundListOperations<String, String> userList = stringRedisTemplate.boundListOps("user:1:order:list");
        userList.leftPushAll(orderKey1,orderKey2,orderKey3);

        //新产生一个订单
        BoundHashOperations<String, Object, Object> user4Order = stringRedisTemplate.boundHashOps("order:4");
        user4Order.put("orderId","4");
        user4Order.put("money","40");
        user4Order.put("time","2018");

        //追加order:4 放入队列的第一个位置
        BoundListOperations<String, String> orderList4 = stringRedisTemplate.boundListOps("user:1:order:list");
        orderList4.leftPush("order:4");

        BoundListOperations<String, String> userListTest = stringRedisTemplate.boundListOps("user:1:order:list");
        //查询用户的所有订单
        List<String> range = userListTest.range(0, -1);

    }


}
