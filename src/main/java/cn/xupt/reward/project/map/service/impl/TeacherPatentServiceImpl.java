package cn.xupt.reward.project.map.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.xupt.reward.project.map.domain.TeacherReward;
import cn.xupt.reward.project.map.mapper.TeacherPatentMapper;
import cn.xupt.reward.project.map.service.TeacherPatentService;

@Service
public class TeacherPatentServiceImpl implements TeacherPatentService{

	@Autowired
	private TeacherPatentMapper teacherPatentMapper;
	
	@Override
	public List<TeacherReward> findAll(String colDate, String colSname, String colType, String colStatus1,
			String money) {
		return teacherPatentMapper.findAll(colDate,colSname,colType,colStatus1,money);
	}

}
