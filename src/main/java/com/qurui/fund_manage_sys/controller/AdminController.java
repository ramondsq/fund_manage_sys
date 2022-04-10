package com.qurui.fund_manage_sys.controller;

import com.qurui.fund_manage_sys.pojo.Admin;
import com.qurui.fund_manage_sys.service.AdminService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@CrossOrigin
public class AdminController {
    @Resource
    AdminService adminService;

    @RequestMapping(path="/adminLogin", method = RequestMethod.POST)
    public Map<String, String> adminLogin(Admin admin) {
        return adminService.adminLogin(admin);
    }
}
