package com.qurui.fund_manage_sys.dao;

import com.qurui.fund_manage_sys.pojo.Project;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
@Mapper
@Component
public interface ProjectDao {
    List<Map<String, Object>> getProjectsBy(Project project);

    int submitProject(Project project);

    int updateProjById(Project project);

    @Delete("DELETE FROM project where project_id = #{project_id}")
    int delProj(Project project);

    @Select("SELECT * FROM project WHERE project_name = #{project_name}")
    Project checkIfExist(Project project);

    int refreshBalance(int project_id, double amount);

    double getBalanceById(int project_id);

    Project getProjById(int project_id);
}
