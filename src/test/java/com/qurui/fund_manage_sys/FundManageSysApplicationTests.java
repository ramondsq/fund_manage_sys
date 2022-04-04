package com.qurui.fund_manage_sys;

import com.qurui.fund_manage_sys.dao.LogDao;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class FundManageSysApplicationTests {
    @Resource
    LogDao logDao;

    @Test
    void contextLoads() {
        System.out.println(logDao.addLog("user1", "提交"));
    }

}
