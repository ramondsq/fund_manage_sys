package com.qurui.fund_manage_sys.service;

import com.qurui.fund_manage_sys.pojo.Category;

import java.util.Map;

public interface CategoryService {
    Map<String, Object> getCategories();
    Map<String, String> setCategory(String category_name);
    Map<String, String> deleteCategory(Category category);
    Map<String, String> rmCate(Category category);
}
