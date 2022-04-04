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
    public Map<String, Object> getCategories() {
        List<Map<String, Object>> list = categoryDao.getCategories();

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
    public Map<String, String> setCategory(String category_name) {
        Category category = categoryDao.checkIfExists(category_name);

        Map<String, String> map = new HashMap<>();

        if(category != null) {
            map.put("code", "0");
        }else {
            categoryDao.setCategory(category_name);
            map.put("code", "1");
        }

        return map;
    }

    @Override
    public Map<String, String> deleteCategory(Category category) {
        int result = categoryDao.deleteCategory(category);

        Map<String, String> map = new HashMap<>();

        if(result == 1) {
            map.put("code", "1");
        }else {
            map.put("code", "0");
        }

        return map;
    }

    @Override
    public Map<String, String> rmCate(Category category) {
        int result = categoryDao.rmCate(category);

        Map<String, String> map = new HashMap<>();

        if(result == 1) {
            map.put("code", "1");
        }else {
            map.put("code", "0");
        }

        return map;
    }
}
