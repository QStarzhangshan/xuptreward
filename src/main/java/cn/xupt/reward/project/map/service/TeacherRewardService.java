package cn.xupt.reward.project.map.service;

import java.util.List;

import cn.xupt.reward.project.map.domain.TeacherReward;

public interface TeacherRewardService {

	List<TeacherReward> listAll(String colDate, String colSname, String colType, String colStatus1, String Money);

}
