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

    @RequestMapping(path = "/getActiveCategories", method= RequestMethod.GET)
    public Map<String, Object> getActiveCategories(){
        return categoryService.getActiveCategories();
    }

    @RequestMapping(path = "/setCategory", method= RequestMethod.POST)
    public Map<String, String> setCategory(Category category){
        return categoryService.setCategory(category);
    }

    @RequestMapping(path = "/modifyCategoryStatus", method= RequestMethod.POST)
    public Map<String, String> modifyCategoryStatus(Category category){
        return categoryService.modifyCategoryStatus(category);
    }

    @RequestMapping(path = "/removeCategory", method= RequestMethod.POST)
    public Map<String, String> removeCategory(Category category){
        return categoryService.removeCategory(category);
    }
}
