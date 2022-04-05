package com.qurui.fund_manage_sys.service.impl;

import com.qurui.fund_manage_sys.dao.LogDao;
import com.qurui.fund_manage_sys.service.LogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LogServiceImpl implements LogService {
    @Resource
    LogDao logDao;

    @Override
    public Map<String, Object> getLogs() {
        List<Map<String, Object>> list = logDao.getLogs();

        Map<String, Object> map = new HashMap<>();

        if(list.size() > 0) {
            map.put("code", "1");
            map.put("logs", list);
        }else {
            map.put("code", "0");
        }

        return map;
    }
}
