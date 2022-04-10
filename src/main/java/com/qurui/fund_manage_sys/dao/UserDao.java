package com.qurui.fund_manage_sys.dao;

import com.qurui.fund_manage_sys.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@Mapper
public interface UserDao {
    User checkUserLogin(User user);
    List<Map<String, Object>> getAllUsers();
    int addUser(User user);
    User checkIfExists(User user);
    @Delete("delete from user_login where user_name = #{user_name}")
    int deleteUser(User user);
    int changeUserPwd(String user_name, String old_pwd, String new_pwd);
}
