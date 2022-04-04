package com.qurui.fund_manage_sys.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;
@Data
@Component
public class Log {
    private int log_no;
    private String log_user;
    private String log_opt;
    private Date log_date;
}
