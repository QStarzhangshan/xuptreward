package cn.xupt.reward.project.map.controller;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;

import cn.xupt.reward.framework.web.controller.BaseController;
import cn.xupt.reward.framework.web.page.TableDataInfo;
import cn.xupt.reward.project.map.domain.TeacherReward;
import cn.xupt.reward.project.map.service.TeacherRewardService;

/**
 * 查询
 * @author lebronzs
 *
 */
@RestController
@RequestMapping("reward")
public class TeacherRewardController extends BaseController{

	@Autowired
	private TeacherRewardService teacherRewardService;
	
	@RequestMapping("/findAll")
	public TableDataInfo listProject2(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse,
			@RequestBody String info) {
		JSONObject obj = JSONObject.parseObject(info);
		String colDate = obj.getString("colDate");
		String colSname = obj.getString("colSname");
		String colType = obj.getString("colType");
		String colStatus1 = obj.getString("colStatus1");
		String Money = obj.getString("Money");
		int pageNum = obj.getIntValue("pageNum");
		int pageSize = obj.getIntValue("pageSize");
		PageHelper.startPage(pageNum, pageSize);
		List<TeacherReward> list = teacherRewardService.listAll(colDate,colSname,colType,colStatus1,Money);
		return getDataTable(list);
	}
	

	
}
