package com.qurui.fund_manage_sys.service.impl;

import com.qurui.fund_manage_sys.dao.ProjectDao;
import com.qurui.fund_manage_sys.dao.RecordDao;
import com.qurui.fund_manage_sys.dao.UserDao;
import com.qurui.fund_manage_sys.pojo.Project;
import com.qurui.fund_manage_sys.pojo.Record;
import com.qurui.fund_manage_sys.service.ProjectService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class ProjectServiceImpl implements ProjectService {
    @Resource
    ProjectDao projectDao;
    @Resource
    RecordDao recordDao;
    @Resource
    UserDao userDao;

    @Override
    public Map<String, Object> getProjectsBy(Project project) {
        List<Map<String, Object>> list = projectDao.getProjectsBy(project);

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
    public Map<String, String> submitProject(Project project) {
        Project project1 = projectDao.checkIfExist(project);

        Map<String, String> map = new HashMap<>();

        if(project1 != null) {
            map.put("code", "0");
            map.put("msg", "已存在同名项目");
        }else {
            projectDao.submitProject(project);

            Record record = new Record();
            record.setFund_amount(project.getProject_budget());
            record.setFund_date(new Date());
            record.setFund_category_id(20010);
            record.setFund_manager(userDao.getUserById(project.getProject_user_id()).getUser_name());
            record.setFund_proj_id(projectDao.checkIfExist(project).getProject_id());
            recordDao.submitRecord(record);

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
    public Map<String, String> updateProjById(Project project) {
        int result = projectDao.updateProjById(project);

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
