package com.qurui.fund_manage_sys.service;

import com.qurui.fund_manage_sys.pojo.Project;

import java.util.Map;

public interface ProjectService {
    Map<String, Object> getProjectsBy(Project project);

    Map<String, String> submitProject(Project project);
    Map<String, String> delProj(Project project);
    Map<String, String> updateProjById(Project project);

}
