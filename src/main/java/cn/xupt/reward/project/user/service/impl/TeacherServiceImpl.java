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
	public List<Teacher> findAll(String colSname, String colDname) {
		return teacherMapper.findAll(colSname,colDname);
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
	public int deleteBycolId(Long colId) {
		return teacherMapper.deleteBycolId(colId);
		
	}

}
