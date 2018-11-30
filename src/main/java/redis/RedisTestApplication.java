package redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @description:
 * @author: hxl
 * @create: 2018-11-29 16:17
 **/

@SpringBootApplication
@EnableCaching
public class RedisTestApplication {
    public static void main(String[] args) {
        SpringApplication.run(RedisTestApplication.class,args);
    }

}
