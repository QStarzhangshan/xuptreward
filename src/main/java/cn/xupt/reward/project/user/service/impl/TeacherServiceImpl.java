package cn.xupt.reward.project.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.xupt.reward.project.user.domain.Teacher;
import cn.xupt.reward.project.user.mapper.TeacherMapper;
import cn.xupt.reward.project.user.service.TeacherService;

@Service("TeacherSerivce")
public class TeacherServiceImpl implements TeacherService{

	@Autowired
	private TeacherMapper teacherMapper;
	
	@Override
	public void insertTeacher(Teacher teacher) {
		teacherMapper.insertTeacher(teacher);
	}

}
