package com.qurui.fund_manage_sys.controller;

import com.qurui.fund_manage_sys.pojo.Record;
import com.qurui.fund_manage_sys.service.RecordService;
import com.qurui.fund_manage_sys.util.JWTUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
public class RecordController {
    @Resource
    RecordService recordService;

    @RequestMapping(path = "/getRecordsBy", method= RequestMethod.GET)
    public Map<String, Object> getRecordsBy(Record record){
        return recordService.getRecordsBy(record);
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

    @RequestMapping(path = "/getRecordsPerCate", method= RequestMethod.GET)
    public Map<String, Object> getRecordsPerCate(Record record){
        return recordService.getRecordsPerCate(record);
    }
}
