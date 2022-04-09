package com.qurui.fund_manage_sys.controller;

import com.qurui.fund_manage_sys.pojo.Record;
import com.qurui.fund_manage_sys.service.RecordService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@CrossOrigin
public class RecordController {
    @Resource
    RecordService recordService;

    @RequestMapping(path = "/getAllRecord", method= RequestMethod.GET)
    public Map<String, Object> getAllRecord(){
        return recordService.getAllRecords();
    }

    @RequestMapping(path = "/getUserRecord", method= RequestMethod.POST)
    public Map<String, Object> getUserRecord(Record record){
        return recordService.getUserRecords(record);
    }

    @RequestMapping(path = "/auditRecord", method= RequestMethod.POST)
    public Map<String, String> auditRecord(Record record){
        return recordService.auditRecord(record);
    }

    @RequestMapping(path = "/deleteRecord", method= RequestMethod.POST)
    public Map<String, String> deleteRecord(Record record){
        return recordService.deleteRecord(record);
    }

    @RequestMapping(path = "/modifyRecord", method= RequestMethod.POST)
    public Map<String, String> modifyRecord(Record record){
        return recordService.modifyRecord(record);
    }

    @RequestMapping(path = "/submitRecord", method= RequestMethod.POST)
    public Map<String, String> submitRecord(Record record){
        return recordService.submitRecord(record);
    }

    @RequestMapping(path = "/getRecordsByCate", method= RequestMethod.POST)
    public Map<String, Object> getRecordsByCate(Record record){
        return recordService.getRecordsByCate(record);
    }

    @RequestMapping(path = "/getUserRecordsByCate", method= RequestMethod.POST)
    public Map<String, Object> getUserRecordsByCate(Record record){
        return recordService.getUserRecordsByCate(record);
    }
}
