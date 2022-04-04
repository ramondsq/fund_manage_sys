package com.qurui.fund_manage_sys.service.impl;

import com.qurui.fund_manage_sys.dao.RecordDao;
import com.qurui.fund_manage_sys.pojo.Record;
import com.qurui.fund_manage_sys.service.RecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RecordServiceImpl implements RecordService {
    @Resource
    RecordDao recordDao;

    @Override
    public Map<String, Object> getAllRecords() {
        List<Map<String, Object>> list = recordDao.getAllRecords();

        Map<String, Object> map = new HashMap<>();

        if(list.size() > 0) {
            map.put("code", "1");
            map.put("records", list);
        }else {
            map.put("code", "0");
        }

        return map;
    }

    @Override
    public Map<String, Object> getUserRecords(Record record) {
        List<Map<String, Object>> list = recordDao.getUserRecords(record);

        Map<String, Object> map = new HashMap<>();

        if(list.size() > 0) {
            map.put("code", "1");
            map.put("records", list);
        }else {
            map.put("code", "0");
        }

        return map;
    }

    @Override
    public Map<String, String> auditRecord(Record record) {
        int result = recordDao.auditRecord(record);

        Map<String, String> map = new HashMap<>();

        if(result == 0) {
            map.put("code", "0");
        }else {
            map.put("code", "1");
        }

        return map;
    }

    @Override
    public Map<String, String> deleteRecord(Record record) {
        int result = recordDao.deleteRecord(record);

        Map<String, String> map = new HashMap<>();

        if(result == 1) {
            map.put("code", "1");
        }else {
            map.put("code", "0");
        }

        return map;
    }

    @Override
    public Map<String, String> modifyRecord(Record record) {
        int result = recordDao.modifyRecord(record);

        Map<String, String> map = new HashMap<>();

        if(result == 1) {
            map.put("code", "1");
        }else {
            map.put("code", "0");
        }

        return map;
    }

    @Override
    public Map<String, String> submitRecord(Record record) {
        int result = recordDao.submitRecord(record);

        Map<String, String> map = new HashMap<>();

        if(result == 1) {
            map.put("code", "1");
        }else {
            map.put("code", "0");
        }

        return map;
    }
}
