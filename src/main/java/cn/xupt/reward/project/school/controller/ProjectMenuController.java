package cn.xupt.reward.project.school.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

import cn.xupt.reward.project.school.domain.ProjectType;
import cn.xupt.reward.project.school.service.ProjectTypeService;

@RestController

public class ProjectMenuController {
	
	@Autowired
	private ProjectTypeService projectTypeService;
	
	/**
	 * 选择一级项目
	 *
	 */
	@RequestMapping("findProjectType")
	public List<String> findAll() {
		List<String> list = projectTypeService.findAll();
		return list;
	}
	
	/**
	 * 根据一级项目，选择二级项目
	 */
	@RequestMapping("findProjectSubtype")
	public List<ProjectType> findAllType(@RequestBody String p) {
		JSONObject obj = JSONObject.parseObject(p);
		String colType = obj.getString("colType");
		List<ProjectType> projectTypes = projectTypeService.findAllByType(colType);
		return projectTypes;
	}
}
