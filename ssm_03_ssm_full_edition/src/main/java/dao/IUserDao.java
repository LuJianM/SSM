package dao;

import model.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Repository(value = "userDao")
public interface IUserDao {

    @Select("select * from user1")
    List<User> findAll();



    User login(@Param("account") String account, @Param("password") String password);
}
