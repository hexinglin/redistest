package RedisMysql.controller;


import RedisMysql.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: hxl
 * @create: 2018-11-30 10:26
 **/

@RestController
@EnableCaching

public class UserController {

//TODO 注意  redis 不仅仅只是用在controller中，他在任意个函数都可以使用，只要放在某个函数就可，只要参数不变结果就变
    private final Logger log = LoggerFactory.getLogger(UserController.class);

    @Cacheable(value = "user")
    @RequestMapping(value = "redis/user" ,method = RequestMethod.GET,produces = "application/json")
    public User getuserbyname(int id){
        log.info("进入 controller-get:name");
        User uu =  new User();
        uu.setAge(24);
        uu.setName("hhhhhhhh");
        return uu;
    }

    @CachePut(value = "user", key = "#root.caches[0].name + ':' + #user.id")
    @RequestMapping(value = "redis/user" ,method = RequestMethod.POST,consumes = "application/json",produces = "application/json")
    public User putuser(@RequestBody User user){
        log.info("进入 controller-put:{}",user);
//        User uu =  new User();
//        uu.setAge(24);
//        uu.setName("hhhhhhhh");
        return user;
    }


    @CacheEvict(value = "user")
    @RequestMapping(value = "redis/user" ,method = RequestMethod.DELETE,produces = "application/json")
    public String deleteuser(int id){
        log.info("进入 controller-dele:");
//        User uu =  new User();
//        uu.setAge(24);
//        uu.setName("hhhhhhhh");
        return "ok";
    }


    //#root.caches[0].name:当前被调用方法所使用的Cache, 即"user" 使用的对象是返回值的对象
    @CachePut(value = "user", key = "#root.caches[0].name + ':' + #user.id")
    @RequestMapping(value = "redis/user",method = RequestMethod.PUT,consumes = "application/json")
    public User updateUser(Integer id, @RequestBody User user) {
        log.info("进入 controller-update:id:{},user:{}",id, user);
//        user.setId(id);
//        userService.update(user);
        return user;
    }





}
