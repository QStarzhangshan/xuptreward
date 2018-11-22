package cn.xupt.reward.project.constant.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.xupt.reward.project.constant.mapper.PatentScoreMapper;
import cn.xupt.reward.project.constant.service.PatentScoreService;
@Service
public class PatentScoreServiceImpl implements PatentScoreService{

	@Autowired
	private PatentScoreMapper patentScoreMapper;
	
	@Override
	public List<String> findAllType() {
		return patentScoreMapper.findAllType();
	}

	
}
