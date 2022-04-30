package com.qurui.fund_manage_sys;

import com.qurui.fund_manage_sys.dao.CategoryDao;
import com.qurui.fund_manage_sys.dao.LogDao;
import com.qurui.fund_manage_sys.dao.RecordDao;
import com.qurui.fund_manage_sys.pojo.Category;
import com.qurui.fund_manage_sys.pojo.Record;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@SpringBootTest
class FundManageSysApplicationTests {
    @Resource
    CategoryDao categoryDao;

    @Resource
    RecordDao recordDao;

    @Test
    void contextLoads() {
        Category category = new Category();
        List<Map<String, Object>> list = categoryDao.getCategoriesBy(category);
        System.out.println(list);
        for (Map<String, Object> map : list) {
            System.out.println(map.get("category_id"));
        }


    }

    @Test
    void testRecordDao() {
//        System.out.println(recordDao.getSumByCate(20001));
    }

}
