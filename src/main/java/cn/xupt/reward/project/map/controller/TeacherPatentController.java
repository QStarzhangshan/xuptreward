package cn.xupt.reward.project.map.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;

import cn.xupt.reward.framework.web.controller.BaseController;
import cn.xupt.reward.framework.web.page.TableDataInfo;
import cn.xupt.reward.project.map.domain.TeacherReward;
import cn.xupt.reward.project.map.service.TeacherPatentService;

@RestController
@RequestMapping("patent")
public class TeacherPatentController extends BaseController{

	@Autowired
	private TeacherPatentService teacherPatentService;
	
	@RequestMapping("/findAll")
	public TableDataInfo findAll(@RequestBody String info) {
		JSONObject obj = JSONObject.parseObject(info);
		String colDate = obj.getString("colDate");
		String colSname = obj.getString("colSname");
		String colType = obj.getString("colType");
		String colStatus1 = obj.getString("colStatus1");
		String Money = obj.getString("Money");
		int pageNum = obj.getIntValue("pageNum");
		int pageSize = obj.getIntValue("pageSize");
		PageHelper.startPage(pageNum, pageSize);
		List<TeacherReward> list = teacherPatentService.findAll(colDate,colSname,colType,colStatus1,Money);
		return getDataTable(list);
	}
}
