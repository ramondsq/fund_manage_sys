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

    @RequestMapping(path = "/getCategoriesBy", method= RequestMethod.GET)
    public Map<String, Object> getCategoriesBy(Category category){
        return categoryService.getCategoriesBy(category);
    }


    @RequestMapping(path = "/submitCategory", method= RequestMethod.POST)
    public Map<String, String> submitCategory(Category category){
        return categoryService.submitCategory(category);
    }

    @RequestMapping(path = "/modifyCategory", method= RequestMethod.POST)
    public Map<String, String> modifyCategory(Category category){
        return categoryService.modifyCategory(category);
    }

    @RequestMapping(path = "/removeCategory", method= RequestMethod.POST)
    public Map<String, String> removeCategory(Category category){
        return categoryService.removeCategory(category);
    }
}
