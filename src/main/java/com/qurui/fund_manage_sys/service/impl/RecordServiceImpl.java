package com.qurui.fund_manage_sys.service.impl;

import com.qurui.fund_manage_sys.dao.CategoryDao;
import com.qurui.fund_manage_sys.dao.ProjectDao;
import com.qurui.fund_manage_sys.dao.RecordDao;
import com.qurui.fund_manage_sys.pojo.Category;
import com.qurui.fund_manage_sys.pojo.Record;
import com.qurui.fund_manage_sys.service.RecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RecordServiceImpl implements RecordService {
    @Resource
    RecordDao recordDao;
    @Resource
    ProjectDao projectDao;
    @Resource
    CategoryDao categoryDao;

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
        Record originRecord = recordDao.getRecordById(record);//获取原记录
        double balance = projectDao.getBalanceById(originRecord.getFund_proj_id());

        Map<String, String> map = new HashMap<>();

        if (balance + originRecord.getFund_amount() < 0) {//看审计通过后余额是否大于0
            map.put("code", "0");
            map.put("msg", "余额不足");
        } else {
            if (record.getFund_audit() == 2) {//如果审计通过，则刷新project的balance
                projectDao.refreshBalance(originRecord.getFund_proj_id(),originRecord.getFund_amount());
            } else if (record.getFund_audit() == 3 && originRecord.getFund_audit() == 2) {//原来是通过了审核现在撤销
                projectDao.refreshBalance(originRecord.getFund_proj_id(),-originRecord.getFund_amount());
            }
            int result = recordDao.auditRecord(record);
            if(result == 0) {
                map.put("code", "0");
            }else {
                map.put("code", "1");
            }
        }

        return map;
    }

    @Override
    public Map<String, String> deleteRecord(Record record) {
        Record originRecord = recordDao.getRecordById(record);
        if (originRecord.getFund_audit() == 2) {//如果审计通过，则刷新project的balance
            projectDao.refreshBalance(originRecord.getFund_proj_id(),-originRecord.getFund_amount());
        }

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

    @Override
    public Map<String, Object> getRecordsPerCate(Record record) {
        Category category = new Category();
        List<Map<String, Object>> list = categoryDao.getCategoriesBy(category);

        Map<String, Object> mapOut = new HashMap<>();

        if(list.size() > 0) {
            mapOut.put("code", "1");
            List<Map<String, Object>> data = new ArrayList<>();
            for (Map<String, Object> map : list) {
                if (map.get("category_id").toString().equals("20010")) {
                    continue;
                }
                Record tempRecord = new Record();

                String category_name = map.get("category_name").toString();
                String category_id = map.get("category_id").toString();

                tempRecord.setFund_category_id(Integer.parseInt(category_id));
                tempRecord.setFund_proj_id(record.getFund_proj_id());

                double sum = recordDao.getSumByCate(tempRecord);
                Map<String, Object> category_sum = new HashMap<>();
                category_sum.put("category_name", category_name);
                category_sum.put("amount", -sum);
                data.add(category_sum);
            }
            mapOut.put("data", data);
        }else {
            mapOut.put("code", "0");
        }

        return mapOut;
    }


}
