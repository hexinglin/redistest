package RedisMysql.Service;


import RedisMysql.dao.UserRepository;
import RedisMysql.entity.User;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author: hxl
 * @create: 2018-11-30 16:54
 **/


@Service("userService")
@EnableCaching
public class UserServiceImpl  implements UserService{

    @Resource
    private UserRepository userRepository;

    @Resource
    private UserRedisServiceImpl userRedisService;

    @Cacheable(value="userCache") //缓存,这里没有指定key.
    @Override
    public String findById(Long id) {
        // TODO Auto-generated method stub
        return userRepository.getOne(id).toString();
    }

    @Cacheable(value="userCache")
    @Override
    public List<User> findAll() {
        // TODO Auto-generated method stub
        return userRepository.findAll();
    }

    //allEntries 清空缓存所有属性 确保更新后缓存刷新
    @CacheEvict(value="userCache", allEntries=true)
    @Override
    public void save(User user) {
        // TODO Auto-generated method stub
        userRepository.save(user);
        if(user.getRediskey()==null||"".equals(user.getRediskey().trim())){
            user.setRediskey(user.getId().toString());
            userRepository.save(user);
        }
        userRedisService.put(user.getRediskey(), user, -1);
    }

    //allEntries 清空缓存所有属性 确保更新后缓存刷新
    @CacheEvict(value="userCache", allEntries=true)
    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        User user=userRepository.getOne(id);
        userRedisService.remove(user.getRediskey());
        userRepository.deleteById(id);
    }

}
