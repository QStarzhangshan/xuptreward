package cn.xupt.reward.project.map.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.xupt.reward.project.map.domain.TeacherReward;
import cn.xupt.reward.project.map.mapper.TeacherRewardMapper;
import cn.xupt.reward.project.map.service.TeacherRewardService;

@Service
public class TeacherRewardServiceImpl implements TeacherRewardService{
	
	@Autowired
	private TeacherRewardMapper teacherRewardMapper;

	@Override
	public List<TeacherReward> listAll(String colDate, String colSname, String colType, String colStatus1,
			String Money) {
		System.out.println(Money);
		return teacherRewardMapper.listAll(colDate,colSname,colType,colStatus1,Money);
	}
	
}
