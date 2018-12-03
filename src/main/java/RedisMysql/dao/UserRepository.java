package RedisMysql.dao;


import RedisMysql.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


/**
 * @description:
 * @author: hxl
 * @create: 2018-11-30 16:48
 **/


public interface UserRepository extends JpaRepository<User, Long> {

}