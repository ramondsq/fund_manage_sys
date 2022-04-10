package com.qurui.fund_manage_sys.service;

import com.qurui.fund_manage_sys.pojo.Log;

import java.util.Map;

public interface LogService {
    Map<String, Object> getLogsBy(Log log);

}
