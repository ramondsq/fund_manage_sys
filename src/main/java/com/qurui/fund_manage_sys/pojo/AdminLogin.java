package com.qurui.fund_manage_sys.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class AdminLogin {
    private String admin_name;
    private String admin_pwd;
}
