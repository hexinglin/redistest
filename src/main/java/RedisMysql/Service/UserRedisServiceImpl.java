package RedisMysql.Service;


import RedisMysql.entity.User;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: hxl
 * @create: 2018-11-30 16:52
 **/


@Service("userRedisService")
public class UserRedisServiceImpl extends RedisService<User>{

    //自定义redis key作为Hash表的key名称
    private static final String REDIS_KEY = "USER_KEY";

    @Override
    protected String getRedisKey() {
        // TODO Auto-generated method stub
        return REDIS_KEY;
    }

}
