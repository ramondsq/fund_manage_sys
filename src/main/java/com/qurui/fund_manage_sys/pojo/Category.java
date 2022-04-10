package com.qurui.fund_manage_sys.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Category {
    private int category_id;
    private String category_name;
    private int category_status;
    private int category_proj_id;
}
