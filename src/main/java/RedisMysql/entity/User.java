package RedisMysql.entity;


import javax.persistence.*;
import java.io.Serializable;

/**
 * @description:
 * @author: hxl
 * @create: 2018-11-29 16:52
 **/



@Entity
@Table(name="t_user")
public class User implements Serializable{

    private static final long serialVersionUID = 7620190115030043228L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private int age;
    private String rediskey;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getRediskey() {
        return rediskey;
    }

    public void setRediskey(String rediskey) {
        this.rediskey = rediskey;
    }

    @Override
    public String toString() {
        return "User[id:"+id+",name:"+name+",age:"+age+"]";
    }
}
