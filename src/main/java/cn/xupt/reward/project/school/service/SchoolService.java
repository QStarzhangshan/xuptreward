package cn.xupt.reward.project.school.service;

import java.util.List;

import cn.xupt.reward.project.school.domain.BaseSchool;

public interface SchoolService {

	List<BaseSchool> findAll();

	List<BaseSchool> findOne(String colSchool);



}
