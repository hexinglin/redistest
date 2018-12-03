package RedisMysql.Service;


import RedisMysql.entity.User;

import java.util.List;

/**
 * @description:
 * @author: hxl
 * @create: 2018-11-30 16:53
 **/


public interface UserService {

    /**
     * 根据Id查询用户信息
     * @param id
     * @return
     */
    public String findById(Long id);

    /**
     * 查询所有用户信息
     * @return
     */
    public List<User> findAll();

    /**
     * 添加或修改用户信息
     * @param user
     */
    public void save(User user);

    /**
     * 根据Id删除用户信息
     * @param id
     */
    public void delete(Long id);

}
