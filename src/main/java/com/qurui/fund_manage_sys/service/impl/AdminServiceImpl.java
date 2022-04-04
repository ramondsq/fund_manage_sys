package com.qurui.fund_manage_sys.service.impl;

import com.qurui.fund_manage_sys.dao.AdminDao;
import com.qurui.fund_manage_sys.pojo.AdminLogin;
import com.qurui.fund_manage_sys.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
@Service
public class AdminServiceImpl implements AdminService {
    @Resource
    AdminDao adminDao;

    @Override
    public Map<String, String> adminLogin(AdminLogin adminLogin) {
        AdminLogin admin = adminDao.checkAdminLogin(adminLogin);

        Map<String, String> map = new HashMap<>();

        if (admin != null){
            map.put("code", "1");
        }else {
            map.put("code","0");
        }

        return map;
    }
}
