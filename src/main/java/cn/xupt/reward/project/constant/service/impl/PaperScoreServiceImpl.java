package cn.xupt.reward.project.constant.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.xupt.reward.project.constant.mapper.PaperScoreMapper;
import cn.xupt.reward.project.constant.service.PaperScoreService;

@Service
public class PaperScoreServiceImpl implements PaperScoreService{

	@Autowired
	private PaperScoreMapper paperScoreMapper;
	
	@Override
	public List<String> findAllType() {
		return paperScoreMapper.findAllType();
	}

	
	
}
