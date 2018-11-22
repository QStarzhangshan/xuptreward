package cn.xupt.reward.project.constant.service;

import java.util.List;

public interface RewardScoreService {

	List<String> findAllcolType();

	List<String> findAllSubType(String colType);

}
