package cn.xupt.reward.project.user.service.impl;

import java.util.List;

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

	@Override
	public List<Teacher> findAll(String colName, String colSchool) {
		return teacherMapper.findAll(colName,colSchool);
	}

	@Override
	public Teacher findByCode(String colCode) {
		return teacherMapper.findByCode(colCode);
	}

	@Override
	public void updateTeacher(Teacher teacher1) {
		teacherMapper.updateTeacher(teacher1);
		
	}

	@Override
	public void deleteBycolId(Long colId) {
		teacherMapper.deleteBycolId(colId);
		
	}

}
