package com.qurui.fund_manage_sys.dao;

import com.qurui.fund_manage_sys.pojo.AdminLogin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface AdminDao {
    AdminLogin checkAdminLogin(AdminLogin adminLogin);
}
