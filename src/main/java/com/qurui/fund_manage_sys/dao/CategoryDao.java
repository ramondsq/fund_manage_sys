package com.qurui.fund_manage_sys.dao;

import com.qurui.fund_manage_sys.pojo.Category;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@Mapper
public interface CategoryDao {
    List<Map<String, Object>> getCategories();
    int setCategory(String category_name);
    Category checkIfExists(String category_name);
    @Update("UPDATE fund_category SET category_status = #{category_status} " +
            "WHERE category_name = #{category_name}")
    int deleteCategory(Category category);
    @Delete("DELETE FROM fund_category WHERE category_name = #{category_name}")
    int rmCate(Category category);
}
