package cn.xupt.reward.project.map.service;

import java.util.List;

import cn.xupt.reward.project.map.domain.TeacherReward;

public interface TeacherPatentService {

	List<TeacherReward> findAll(String colDate, String colSname, String colType, String colStatus1, String money);

}
