package cn.xupt.reward.project.constant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * 期刊
 * @author lebronzs
 *
 */
import cn.xupt.reward.project.constant.service.PaperScoreService;

@RestController
@RequestMapping("paper")
public class PaperScoreController {

	@Autowired
	private PaperScoreService paperScoreService;
	
	@RequestMapping("/findAllType")
	public List<String> findAllType(){
		List<String> list = paperScoreService.findAllType();
		return list;
	} 
}
