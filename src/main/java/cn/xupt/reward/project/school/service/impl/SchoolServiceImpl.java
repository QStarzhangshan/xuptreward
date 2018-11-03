package cn.xupt.reward.project.school.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.xupt.reward.project.school.domain.BaseSchool;
import cn.xupt.reward.project.school.mapper.SchoolMapper;
import cn.xupt.reward.project.school.service.SchoolService;

@Service("SchoolService")
public class SchoolServiceImpl implements SchoolService{

	@Autowired
	private SchoolMapper schoolMapper;
	
	@Override
	public List<BaseSchool> findAll() {
		return schoolMapper.findAll();
	}

	@Override
	public List<BaseSchool> findOne(String colSchool) {
		return schoolMapper.findOne(colSchool);
	}
	
}
