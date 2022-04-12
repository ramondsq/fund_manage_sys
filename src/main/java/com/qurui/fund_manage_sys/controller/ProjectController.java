package com.qurui.fund_manage_sys.controller;

import com.qurui.fund_manage_sys.pojo.Project;
import com.qurui.fund_manage_sys.service.ProjectService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@CrossOrigin
public class ProjectController {
    @Resource
    ProjectService projectService;

    @RequestMapping(path = "/getProjectsBy", method= RequestMethod.GET)
    public Map<String, Object> getProjectsBy(Project project){
        return projectService.getProjectsBy(project);
    }





    @RequestMapping(path = "/submitProject", method= RequestMethod.POST)
    public Map<String, String> submitProject(Project project){
        return projectService.submitProject(project);
    }

    @RequestMapping(path = "/delProj", method= RequestMethod.POST)
    public Map<String, String> delProj(Project project){
        return projectService.delProj(project);
    }

    @RequestMapping(path = "/updateProjById", method= RequestMethod.POST)
    public Map<String, String> updateProjById(Project project){
        return projectService.updateProjById(project);
    }

    @RequestMapping(path = "/updateProjName", method= RequestMethod.POST)
    public Map<String, String> updateProjName(String old_name, String new_name){
        return projectService.updateProjName(old_name, new_name);
    }
}
