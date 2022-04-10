package com.qurui.fund_manage_sys.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class User {
    private int user_id;
    private String user_name;
    private String user_pwd;
    private int user_proj_id;
}
