package com.qurui.fund_manage_sys.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
@Component
public class Record {
    private int fund_id;
    private double fund_amount;
    private Date fund_date;
    private int fund_category_id;
    private String fund_manager;
    private int fund_audit;
    private Date fund_change_date;
    private int fund_proj_id;
}
