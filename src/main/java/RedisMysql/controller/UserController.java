package RedisMysql.controller;


import RedisMysql.Service.UserService;
import RedisMysql.entity.User;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author: hxl
 * @create: 2018-11-30 10:26
 **/

@RestController
@EnableCaching

public class UserController {
    private static Integer userNum=0;

    @Resource
    private UserService userService;

    /**
     * 根据Id查询用户信息
     * @param id
     * @return
     */
    @RequestMapping(value = "/findById/{id}")
    public String findById(@PathVariable("id")Long id){
        return userService.findById(id);
    }

    /**
     * 查询所有用户信息
     * @return
     */
    @RequestMapping("/findAll")
    public List<User> findAll(){
        return userService.findAll();
    }

    /**
     * 添加用户信息
     * @return
     */
    @RequestMapping("/add")
    public String add(){
        User user=new User();
        ++userNum;
        user.setName("张三"+userNum);
        userService.save(user);
        return "success";
    }

    /**
     * 修改用户信息
     * @return
     */
    @RequestMapping("/update/{id}")
    public String update(@PathVariable("id")Long id){
//        User user=userService.findById(id);
//        user.setName(user.getName()+"asd");
//        userService.save(user);
        return "success";
    }

    /**
     * 根据Id删除用户信息
     * @return
     */
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id")Long id){
        userService.delete(id);
        return "success";
    }





}
