package cn.xupt.reward.project.school.service;

import java.util.List;

import cn.xupt.reward.project.school.domain.BaseSubSchool;

public interface SubSchoolService {

	List<BaseSubSchool> findAllBySchool(String colSname);

}
