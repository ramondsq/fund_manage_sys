package com.qurui.fund_manage_sys.controller;

import com.qurui.fund_manage_sys.pojo.Log;
import com.qurui.fund_manage_sys.service.LogService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@CrossOrigin
public class LogController {
    @Resource
    LogService logService;

    @RequestMapping(path = "/getLogsBy", method= RequestMethod.GET)
    public Map<String, Object> getLogsBy(Log log){
        return logService.getLogsBy(log);
    }


}
