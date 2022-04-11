package com.qurui.fund_manage_sys.service.impl;

import com.qurui.fund_manage_sys.dao.LogDao;
import com.qurui.fund_manage_sys.dao.UserDao;
import com.qurui.fund_manage_sys.pojo.User;
import com.qurui.fund_manage_sys.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Resource
    private LogDao logDao;

    @Override
    public Map<String, String> userLogin(User userLogin) {
        User user = userDao.userLogin(userLogin);

        Map<String, String> map = new HashMap<>();

        if (user != null){
            map.put("code", "1");
            logDao.addLog(userDao.getUserByName(userLogin.getUser_name()).getUser_id(),
                    "登录");
        }else {
            map.put("code","0");
        }

        return map;
    }

    @Override
    public Map<String, Object> getUsers() {
        List<Map<String, Object>> list = userDao.getAllUsers();

        Map<String, Object> map = new HashMap<>();

        if(list.size() > 0) {
            map.put("code", "1");
            map.put("users", list);
        }else {
            map.put("code", "0");
        }

        return map;
    }

    @Override
    public Map<String, String> addUser(User user) {
        User result = userDao.checkIfExists(user);

        Map<String, String> map = new HashMap<>();

        if (result != null) {
            map.put("code", "0");
            map.put("msg", "用户名已存在");
        }else{
            userDao.addUser(user);
            logDao.addLog(userDao.getUserByName(user.getUser_name()).getUser_id(),
                    "被添加");
            map.put("code", "1");
        }

        return map;
    }

    @Override
    public Map<String, String> deleteUser(User user) {
        logDao.delUserLog(userDao.getUserByName(user.getUser_name()).getUser_id());

        int result = userDao.deleteUser(user);

        Map<String, String> map = new HashMap<>();

        if (result == 1) {
            map.put("code", "1");
        }else{
            map.put("code", "0");
        }

        return map;
    }

    @Override
    public Map<String, String> changeUserPwd(String user_name, String old_pwd, String new_pwd) {
        int result = userDao.changeUserPwd(user_name, old_pwd, new_pwd);

        Map<String, String> map = new HashMap<>();

        if (result == 1) {
            map.put("code", "1");
            logDao.addLog(userDao.getUserByName(user_name).getUser_id(),
                    "修改密码");
        }else{
            map.put("code", "0");
        }

        return map;
    }
}
