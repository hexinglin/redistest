package RedisCaching.entity;


import javax.persistence.Entity;
import java.io.Serializable;

/**
 * @description:
 * @author: hxl
 * @create: 2018-11-29 16:52
 **/

@Entity
public class User  implements Serializable {

    private int id ;
    private int age;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "user[id="+id+",age="+age+",name="+name+"]";
    }
}
