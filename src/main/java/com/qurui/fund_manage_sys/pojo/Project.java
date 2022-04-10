package com.qurui.fund_manage_sys.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Project {
    private int project_id;
    private String project_name;
    private int project_status;
}
