package com.qurui.fund_manage_sys.service.impl;

import com.qurui.fund_manage_sys.dao.ProjectDao;
import com.qurui.fund_manage_sys.pojo.Project;
import com.qurui.fund_manage_sys.service.ProjectService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class ProjectServiceImpl implements ProjectService {
    @Resource
    ProjectDao projectDao;

    @Override
    public Map<String, Object> getAllProjects() {
        List<Map<String, Object>> list = projectDao.getAllProjects();

        Map<String, Object> map = new HashMap<>();

        if(list.size() > 0) {
            map.put("code", "1");
            map.put("projects", list);
        }else {
            map.put("code", "0");
        }

        return map;
    }

    @Override
    public Map<String, Object> getActiveProjects() {
        List<Map<String, Object>> list = projectDao.getActiveProjects();

        Map<String, Object> map = new HashMap<>();

        if(list.size() > 0) {
            map.put("code", "1");
            map.put("projects", list);
        }else {
            map.put("code", "0");
        }

        return map;
    }

    @Override
    public Map<String, String> addProject(Project project) {
        Project project1 = projectDao.checkIfExist(project);

        Map<String, String> map = new HashMap<>();

        if(project1 != null) {
            map.put("code", "0");
            map.put("msg", "已存在同名项目");
        }else {
            projectDao.addProject(project);
            map.put("code", "1");
        }

        return map;
    }

    @Override
    public Map<String, String> delProj(Project project) {
        int result = projectDao.delProj(project);

        Map<String, String> map = new HashMap<>();

        if(result == 0) {
            map.put("code", "0");
        }else {
            map.put("code", "1");
        }

        return map;
    }

    @Override
    public Map<String, String> updateProjStat(Project project) {
        int result = projectDao.updateProjStat(project);

        Map<String, String> map = new HashMap<>();

        if(result == 0) {
            map.put("code", "0");
        }else {
            map.put("code", "1");
        }

        return map;
    }

    @Override
    public Map<String, String> updateProjName(String old_name, String new_name) {
        int result = projectDao.updateProjName(old_name, new_name);

        Map<String, String> map = new HashMap<>();

        if(result == 0) {
            map.put("code", "0");
        }else {
            map.put("code", "1");
        }

        return map;
    }
}
