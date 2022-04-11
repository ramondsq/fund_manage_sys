package com.qurui.fund_manage_sys.service.impl;

import com.qurui.fund_manage_sys.dao.CategoryDao;
import com.qurui.fund_manage_sys.pojo.Category;
import com.qurui.fund_manage_sys.service.CategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Resource
    CategoryDao categoryDao;

    @Override
    public Map<String, Object> getCategoriesBy(Category category) {
        List<Map<String, Object>> list = categoryDao.getCategoriesBy(category);

        Map<String, Object> map = new HashMap<>();

        if(list.size() > 0) {
            map.put("code", "1");
            map.put("categories", list);
        }else {
            map.put("code", "0");
        }

        return map;
    }


    @Override
    public Map<String, String> submitCategory(Category category) {
        Category category1 = categoryDao.checkIfExists(category);

        Map<String, String> map = new HashMap<>();

        if(category1 != null) {
            map.put("code", "0");
        }else {
            categoryDao.submitCategory(category);
            map.put("code", "1");
        }

        return map;
    }



    @Override
    public Map<String, String> removeCategory(Category category) {
        int result = categoryDao.removeCategory(category);

        Map<String, String> map = new HashMap<>();

        if(result == 1) {
            map.put("code", "1");
        }else {
            map.put("code", "0");
        }

        return map;
    }
}
