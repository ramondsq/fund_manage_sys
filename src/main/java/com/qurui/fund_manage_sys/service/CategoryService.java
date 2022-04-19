package com.qurui.fund_manage_sys.service;

import com.qurui.fund_manage_sys.pojo.Category;

import java.util.Map;

public interface CategoryService {
    Map<String, Object> getCategoriesBy(Category category);

    Map<String, String> submitCategory(Category category);

    Map<String, String> removeCategory(Category category);

    Map<String, String> modifyCategory(Category category);
}
