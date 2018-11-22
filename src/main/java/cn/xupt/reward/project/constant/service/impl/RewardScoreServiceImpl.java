package cn.xupt.reward.project.constant.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.xupt.reward.project.constant.mapper.RewardScoreMapper;
import cn.xupt.reward.project.constant.service.RewardScoreService;

@Service
public class RewardScoreServiceImpl implements RewardScoreService{
	
	@Autowired
	private RewardScoreMapper rewardScoreMapper;

	@Override
	public List<String> findAllcolType() {
		return rewardScoreMapper.findAllcolType();
	}

	@Override
	public List<String> findAllSubType(String colType) {
		return rewardScoreMapper.findAllSubType(colType);
	}
}
