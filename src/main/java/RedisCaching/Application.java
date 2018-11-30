package RedisCaching;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @description:
 * @author: hxl
 * @create: 2018-11-30 10:09
 **/

@SpringBootApplication
@EnableCaching
public class Application {

    public static void main(String[] args){
        SpringApplication.run(Application.class,args);
    }


}
