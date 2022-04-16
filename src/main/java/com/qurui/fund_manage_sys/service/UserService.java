package com.qurui.fund_manage_sys.service;

import com.qurui.fund_manage_sys.pojo.User;

import java.util.Map;

public interface UserService {
    Map<String, Object> userLogin(User user);
    Map<String, Object> getUsers();
    Map<String, String> addUser(User user);
    Map<String, String> deleteUser(User user);
    Map<String, String> changeUserPwd(String user_name, String old_pwd, String new_pwd);
}
