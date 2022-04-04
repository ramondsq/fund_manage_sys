package com.qurui.fund_manage_sys.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Category {
    private String category_name;
    private int category_status;
}
