package com.qurui.fund_manage_sys.dao;

import com.qurui.fund_manage_sys.pojo.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface AdminDao {
    Admin checkAdminLogin(Admin admin);
}
