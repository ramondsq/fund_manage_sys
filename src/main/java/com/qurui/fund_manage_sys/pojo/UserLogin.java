package com.qurui.fund_manage_sys.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class UserLogin {
    private String user_name;
    private String user_pwd;
}
