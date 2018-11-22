package cn.xupt.reward.project.constant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

import cn.xupt.reward.project.constant.service.RewardScoreService;

/**
 * 科研获奖controller
 * @author lebronzs
 *
 */
@RestController
@RequestMapping("reward")
public class RewardScoreController {
	
	@Autowired
	private RewardScoreService rewardScoreService;
	
	/**
	 * 查询所有获奖
	 * @return
	 */
	@RequestMapping("/findAllType")
	public List<String> findAllcolType(){
		List<String> list = rewardScoreService.findAllcolType();
		return list;
	}
	
	@RequestMapping("/findAllSubType")
	public List<String> findAllSubType(@RequestBody String info){
		JSONObject obj = JSONObject.parseObject(info);
		String colType = obj.getString("colType");
		List<String> list = rewardScoreService.findAllSubType(colType);
		return list;
	}
	
	
}
