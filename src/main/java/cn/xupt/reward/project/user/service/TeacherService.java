package cn.xupt.reward.project.user.service;

import java.util.List;

import cn.xupt.reward.project.user.domain.Teacher;

public interface TeacherService {

	void insertTeacher(Teacher teacher);

	List<Teacher> findAll(String colSname, String colDname);

	Teacher findByCode(String colCode);

	void updateTeacher(Teacher teacher1);

	int deleteBycolId(Long colId);
	
	
}
