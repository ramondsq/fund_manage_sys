package com.qurui.fund_manage_sys.service;

import com.qurui.fund_manage_sys.pojo.UserLogin;

import java.util.Map;

public interface UserService {
    Map<String, String> userLogin(UserLogin userLogin);
    Map<String, Object> getUsers();
    Map<String, String> addUser(UserLogin userLogin);
    Map<String, String> deleteUser(UserLogin userLogin);
    Map<String, String> changeUserPwd(String user_name, String old_pwd, String new_pwd);
}
