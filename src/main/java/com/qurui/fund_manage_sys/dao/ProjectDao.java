package com.qurui.fund_manage_sys.dao;

import com.qurui.fund_manage_sys.pojo.Project;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
@Mapper
@Component
public interface ProjectDao {
    @Select("SELECT * FROM project")
    List<Map<String, Object>> getAllProjects();

    @Select("SELECT * FROM project WHERE project_status = 1")
    List<Map<String, Object>> getActiveProjects();

    @Insert("INSERT INTO project (project_name) VALUES (#{project_name})")
    int addProject(Project project);

    @Delete("DELETE FROM project where project_name = #{project_name}")
    int delProj(Project project);

    @Update("UPDATE project SET project_status = #{project_status} WHERE project_name = #{project_name}")
    int updateProjStat(Project project);

    int updateProjName(String old_name, String new_name);
}
