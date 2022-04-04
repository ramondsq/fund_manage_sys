package com.qurui.fund_manage_sys.controller;

import com.qurui.fund_manage_sys.pojo.UserLogin;
import com.qurui.fund_manage_sys.service.UserService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@CrossOrigin
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping(path = "/userLogin", method= RequestMethod.POST)
    public Map<String, String> userLogin(UserLogin user){
        return userService.userLogin(user);
    }

    @RequestMapping(path = "/getUsers", method= RequestMethod.GET)
    public Map<String, Object> getUsers(){
        return userService.getUsers();
    }

    @RequestMapping(path = "/addUser", method= RequestMethod.POST)
    public Map<String, String> addUser(UserLogin user){
        return userService.addUser(user);
    }

    @RequestMapping(path = "/deleteUser", method= RequestMethod.POST)
    public Map<String, String> deleteUser(UserLogin user){
        return userService.deleteUser(user);
    }

    @RequestMapping(path = "/changeUserPwd", method= RequestMethod.POST)
    public Map<String, String> deleteUser(String user_name, String old_pwd, String new_pwd){
        return userService.changeUserPwd(user_name, old_pwd, new_pwd);
    }
}
