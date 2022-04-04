package com.qurui.fund_manage_sys.controller;

import com.qurui.fund_manage_sys.pojo.Category;
import com.qurui.fund_manage_sys.service.CategoryService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@CrossOrigin
public class CategoryController {
    @Resource
    CategoryService categoryService;

    @RequestMapping(path = "/getCategories", method= RequestMethod.GET)
    public Map<String, Object> getCategories(){
        return categoryService.getCategories();
    }

    @RequestMapping(path = "/setCategory", method= RequestMethod.POST)
    public Map<String, String> setCategory(String category_name){
        return categoryService.setCategory(category_name);
    }

    @RequestMapping(path = "/deleteCategory", method= RequestMethod.POST)
    public Map<String, String> deleteCategory(Category category){
        return categoryService.deleteCategory(category);
    }

    @RequestMapping(path = "/rmCate", method= RequestMethod.POST)
    public Map<String, String> rmCate(Category category){
        return categoryService.rmCate(category);
    }
}
