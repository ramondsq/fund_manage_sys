package com.qurui.fund_manage_sys.service;

import com.qurui.fund_manage_sys.pojo.AdminLogin;

import java.util.Map;

public interface AdminService {
    Map<String, String> adminLogin(AdminLogin adminLogin);
}
