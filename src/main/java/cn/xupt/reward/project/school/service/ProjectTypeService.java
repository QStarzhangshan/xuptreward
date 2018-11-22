package cn.xupt.reward.project.school.service;

import java.util.List;

import cn.xupt.reward.project.school.domain.ProjectType;

public interface ProjectTypeService {

	List<ProjectType> findAllByType(String colType);

	List<String> findAll();
	
	
}
