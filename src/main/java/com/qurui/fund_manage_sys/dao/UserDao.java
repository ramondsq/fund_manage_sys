package com.qurui.fund_manage_sys.dao;

import com.qurui.fund_manage_sys.pojo.UserLogin;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@Mapper
public interface UserDao {
    UserLogin checkUserLogin(UserLogin userLogin);
    List<Map<String, Object>> getAllUsers();
    int addUser(UserLogin userLogin);
    UserLogin checkIfExists(UserLogin userLogin);
    @Delete("delete from user_login where user_name = #{user_name}")
    int deleteUser(UserLogin userLogin);
    int changeUserPwd(String user_name, String old_pwd, String new_pwd);
}
