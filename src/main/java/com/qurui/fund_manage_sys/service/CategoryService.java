package com.qurui.fund_manage_sys.service;

import com.qurui.fund_manage_sys.pojo.Category;

import java.util.Map;

public interface CategoryService {
    Map<String, Object> getCategories();
    Map<String, Object> getActiveCategories();
    Map<String, String> setCategory(Category category);
    Map<String, String> modifyCategoryStatus(Category category);
    Map<String, String> removeCategory(Category category);
}
