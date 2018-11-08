package cn.xupt.reward.project.school.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.xupt.reward.project.school.domain.BaseSubSchool;
import cn.xupt.reward.project.school.mapper.SubSchoolMapper;
import cn.xupt.reward.project.school.service.SubSchoolService;

@Service("SubSchoolService")
public class SubSchoolSerivceImpl implements SubSchoolService{

	@Autowired
	private SubSchoolMapper subSchoolMapper;
	
	@Override
	public List<BaseSubSchool> findAllBySchool(String colSname) {
		return subSchoolMapper.findAllBySchool(colSname);
	}

}
