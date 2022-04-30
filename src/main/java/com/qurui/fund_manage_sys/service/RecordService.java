package com.qurui.fund_manage_sys.service;

import com.qurui.fund_manage_sys.pojo.Record;

import java.util.Map;

public interface RecordService {
    Map<String, Object> getRecordsBy(Record record);

    Map<String, String> auditRecord(Record record);
    Map<String, String> deleteRecord(Record record);
    Map<String, String> modifyRecord(Record record);
    Map<String, String> submitRecord(Record record);
    Map<String, Object> getRecordsPerCate(Record record);
}
