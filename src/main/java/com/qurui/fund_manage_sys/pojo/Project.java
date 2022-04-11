package com.qurui.fund_manage_sys.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Data
public class Project {
    private int project_id;
    private String project_name;
    private int project_status;
    private int project_user_id;
    private double project_budget;
    private double project_balance;
    private Date project_create;
    private Date project_deadline;
}
