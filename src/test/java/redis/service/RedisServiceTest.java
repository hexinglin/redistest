package redis.service;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import redis.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;


/**
 * @description:
 * @author: hxl
 * @create: 2018-11-29 17:14
 **/

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisServiceTest {

    @Autowired
    RedisService redisService;

    @Test
    public void add() {
        User user = new User();
        user.setName("wangjianfen");
        user.setAge(22);
        redisService.add("userByName:" + user.getName(), user, 10L);
    }

    @Test
    public void add1() {
        User user = new User();
        user.setName("wangjianfenaaaaaaaaaaa");
        user.setAge(22);
        redisService.add("userByName:", user, 10L);

    }

    @Test
    public void get() {

//        List<User> list = new ArrayList<>();
//        list.add(user);
//        redisService.add("list", list, 10L);
        User user1 = redisService.get("userByName:wangjianfeng");
        Assert.notNull(user1, "user is null");
        List<User> list2 = redisService.getUserList("list");
        Assert.notNull(list2, "list is null");
        System.out.println("ok");
    }

    @Test
    public void getUserList() {
    }

    @Test
    public void delete() {
        redisService.delete("userByName:wangjianfeng");
    }
}