package cn.xupt.reward.project.map.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.xupt.reward.project.map.domain.TeacherReward;
import cn.xupt.reward.project.map.mapper.TeacherPaperMapper;
import cn.xupt.reward.project.map.service.TeacherPaperService;

@Service
public class TeacherPaperServiceImpl implements TeacherPaperService{

	@Autowired
	private TeacherPaperMapper teacherPaperMapper;
	
	@Override
	public List<TeacherReward> listAll(String colDate, String colSname, String colType, String colStatus1,
			String money,String colDname) {
		return teacherPaperMapper.findAll(colDate,colSname,colType,colStatus1,money,colDname);
	}

}
