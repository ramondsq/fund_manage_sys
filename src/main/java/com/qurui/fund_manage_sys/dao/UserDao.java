package com.qurui.fund_manage_sys.dao;

import com.qurui.fund_manage_sys.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@Mapper
public interface UserDao {
    @Select("SELECT * FROM user " +
            "WHERE user_name = #{user_name} " +
            "AND user_pwd = #{user_pwd}")
    User userLogin(User user);

    @Select("SELECT * FROM user")
    List<Map<String, Object>> getUsers();

    @Insert("INSERT INTO user (user_name, user_pwd) " +
            "VALUES (#{user_name}, #{user_pwd})")
    int addUser(User user);

    @Select("SELECT * FROM user " +
            "WHERE user_name = #{user_name}")
    User checkIfExists(User user);

    @Delete("DELETE FROM user " +
            "WHERE user_name = #{user_name}")
    int deleteUser(User user);

    int changeUserPwd(String user_name, String old_pwd, String new_pwd);

    User getUserByName(String user_name);

    User getUserById(int user_id);
}
