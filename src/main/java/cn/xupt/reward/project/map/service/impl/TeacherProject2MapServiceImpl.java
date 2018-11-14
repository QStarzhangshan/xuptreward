package cn.xupt.reward.project.map.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.xupt.reward.project.map.domain.TeacherProject2Map;
import cn.xupt.reward.project.map.mapper.TeacherProject2MapMapper;
import cn.xupt.reward.project.map.service.TeacherProject2MapService;

@Service
public class TeacherProject2MapServiceImpl implements TeacherProject2MapService{
	
	@Autowired
	private TeacherProject2MapMapper teacherProject2MapMapper;

	@Override
	public int addProject2(String colCode, TeacherProject2Map teacherProject2Map) {
		return teacherProject2MapMapper.addProject2(colCode,teacherProject2Map);
	}

	@Override
	public List<TeacherProject2Map> listAll(String colTtime, String colSname, String colType, String colSubtype,
			String colStatus1, String colStatus2, String colStatus3) {
		return teacherProject2MapMapper.listAll(colTtime,colSname,colType,colSubtype,colStatus1,colStatus2,colStatus3);
	}
}
