package RedisCaching.Service;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cache.annotation.*;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.lang.reflect.Method;
import java.net.UnknownHostException;


/**
 * @description: Standard Redis configuration.
 * @author: hxl
 * @create: 2018-11-29 16:43
 **/


@Configuration
@EnableCaching
public class RedisConfiguration  extends CachingConfigurerSupport {

    @Bean
    @ConditionalOnMissingBean(name = "redisTemplate")
    public RedisTemplate<Object, Object> redisTemplate(
            RedisConnectionFactory redisConnectionFactory)
            throws UnknownHostException {
        RedisTemplate<Object, Object> template = new RedisTemplate<Object, Object>();
        template.setConnectionFactory(redisConnectionFactory);
        return template;
    }

    @Bean
    @ConditionalOnMissingBean(StringRedisTemplate.class)
    public StringRedisTemplate stringRedisTemplate(
            RedisConnectionFactory redisConnectionFactory)
            throws UnknownHostException {
        StringRedisTemplate template = new StringRedisTemplate();
        template.setConnectionFactory(redisConnectionFactory);
        return template;
    }


    // TODO 注意
    // 这里的策略很简单，使用缓存名称 + id
    @Bean
    public KeyGenerator keyGenerator() {
        return new KeyGenerator() {
            @Override
            public Object generate(Object target, Method method, Object... params) {
                StringBuilder sb = new StringBuilder();
                String[] value = new String[1];
                Cacheable cacheable = method.getAnnotation(Cacheable.class);
                if (cacheable != null) {
                    value = cacheable.value();
                }
                CachePut cachePut = method.getAnnotation(CachePut.class);
                if (cachePut != null) {
                    value = cachePut.value();
                }
                CacheEvict cacheEvict = method.getAnnotation(CacheEvict.class);
                if (cacheEvict != null) {
                    value = cacheEvict.value();
                }
                sb.append(value[0]);
                for (Object obj : params) {
                    sb.append(":")
                            .append(obj.toString());
                }
                return sb.toString();
            }
        };
    }


}
