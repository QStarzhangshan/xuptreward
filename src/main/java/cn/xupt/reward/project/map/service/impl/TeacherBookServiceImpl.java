package cn.xupt.reward.project.map.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.xupt.reward.project.map.domain.TeacherReward;
import cn.xupt.reward.project.map.mapper.TeacherBookMapper;
import cn.xupt.reward.project.map.service.TeacherBookService;

@Service
public class TeacherBookServiceImpl implements TeacherBookService{

	@Autowired
	private TeacherBookMapper teacherBookMapper;
	
	@Override
	public List<TeacherReward> listAll(String colDate, String colSname, String colType, String colStatus1,
			String money) {
		return teacherBookMapper.findAll(colDate,colSname,colType,colStatus1,money);
	}

}
