package com.qurui.fund_manage_sys.service;

import com.qurui.fund_manage_sys.pojo.Admin;

import java.util.Map;

public interface AdminService {
    Map<String, String> adminLogin(Admin admin);
}
