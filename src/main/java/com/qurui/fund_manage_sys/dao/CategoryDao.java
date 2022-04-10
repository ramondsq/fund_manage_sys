package com.qurui.fund_manage_sys.dao;

import com.qurui.fund_manage_sys.pojo.Category;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@Mapper
public interface CategoryDao {
    @Select("SELECT * FROM category")
    List<Map<String, Object>> getCategories();

    @Select("SELECT * FROM category " +
            "WHERE category_status = 1")
    List<Map<String, Object>> getActiveCategories();

    @Insert("INSERT INTO category (category_name) " +
            "VALUES (#{category_name})")
    int setCategory(Category category);

    @Select("SELECT * FROM category " +
            "WHERE category_name = #{category_name}")
    Category checkIfExists(Category category);

    @Update("UPDATE category " +
            "SET category_status = #{category_status} " +
            "WHERE category_name = #{category_name}")
    int modifyCategoryStatus(Category category);

    @Delete("DELETE FROM category " +
            "WHERE category_name = #{category_name}")
    int removeCategory(Category category);
}
