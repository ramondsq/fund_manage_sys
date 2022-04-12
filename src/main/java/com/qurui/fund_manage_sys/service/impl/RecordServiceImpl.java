package com.qurui.fund_manage_sys.service.impl;

import com.qurui.fund_manage_sys.dao.ProjectDao;
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
    @Resource
    ProjectDao projectDao;

    @Override
    public Map<String, Object> getRecordsBy(Record record) {
        List<Map<String, Object>> list = recordDao.getRecordsBy(record);

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
        if (record.getFund_audit() == 2) {//如果审计通过，则刷新project的balance
            Record record1 = recordDao.getRecordById(record);
            projectDao.refreshBalance(record1.getFund_proj_id(),record1.getFund_amount());
        }
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
