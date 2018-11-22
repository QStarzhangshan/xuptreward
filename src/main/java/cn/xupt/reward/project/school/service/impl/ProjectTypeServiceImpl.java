package cn.xupt.reward.project.school.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.xupt.reward.project.school.domain.ProjectType;
import cn.xupt.reward.project.school.mapper.ProjectTypeMapper;
import cn.xupt.reward.project.school.service.ProjectTypeService;

@Service("ProjectType")
public class ProjectTypeServiceImpl implements ProjectTypeService{

	@Autowired
	private ProjectTypeMapper projectTypeMapper;
	
	@Override
	public List<ProjectType> findAllByType(String colType) {
		return projectTypeMapper.findAllByType(colType);
	}

	@Override
	public List<String> findAll() {
		return projectTypeMapper.findAll();
	}

	
}
