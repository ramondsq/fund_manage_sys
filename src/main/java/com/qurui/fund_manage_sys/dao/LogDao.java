package com.qurui.fund_manage_sys.dao;

import com.qurui.fund_manage_sys.pojo.Log;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@Mapper
public interface LogDao {
    @Select("select * from logs")
    List<Map<String, Object>> getLogs();

    int addLog(int log_user_id, String log_opt);

    int delUserLog(int log_user_id);
}
