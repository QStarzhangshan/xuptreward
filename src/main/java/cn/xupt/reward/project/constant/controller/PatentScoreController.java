package cn.xupt.reward.project.constant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.xupt.reward.project.constant.service.PatentScoreService;

/**
 * 知识产权
 * @author lebronzs
 *
 */
@RestController
@RequestMapping("patent")
public class PatentScoreController {

	@Autowired
	private PatentScoreService patentScoreService;
	
	@RequestMapping("/findAllType")
	public List<String> findAllType(){
		List<String> list = patentScoreService.findAllType();
		return list;
	}
}
