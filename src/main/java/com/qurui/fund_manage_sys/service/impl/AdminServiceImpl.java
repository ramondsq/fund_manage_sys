package com.qurui.fund_manage_sys.service.impl;

import com.qurui.fund_manage_sys.dao.AdminDao;
import com.qurui.fund_manage_sys.pojo.Admin;
import com.qurui.fund_manage_sys.service.AdminService;
import com.qurui.fund_manage_sys.util.JWTUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
@Service
public class AdminServiceImpl implements AdminService {
    @Resource
    AdminDao adminDao;

    @Override
    public Map<String, String> adminLogin(Admin admin) {
        Admin admin1 = adminDao.checkAdminLogin(admin);

        Map<String, String> map = new HashMap<>();

        if (admin1 != null){
            String token = JWTUtils.createToken(admin.getAdmin_name());
            map.put("code", "1");
            map.put("token", token);
        }else {
            map.put("code","0");
        }

        return map;
    }
}
