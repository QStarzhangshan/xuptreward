package cn.xupt.reward.project.map.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;

import cn.xupt.reward.framework.web.controller.BaseController;
import cn.xupt.reward.framework.web.domain.Message;
import cn.xupt.reward.framework.web.page.TableDataInfo;
import cn.xupt.reward.project.map.domain.TeacherProject2Map;
import cn.xupt.reward.project.map.service.TeacherProject2MapService;
import cn.xupt.reward.project.user.domain.User;

@RestController
@RequestMapping("project")
public class TeacherProject2MapController extends BaseController{
	
	@Autowired
	private TeacherProject2MapService teacherProject2MapService;
	
	@RequestMapping("/findAll")
	public TableDataInfo listProject2(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse,
			@RequestBody String info) {
		JSONObject obj = JSONObject.parseObject(info);
		String colTtime = obj.getString("colTtime");
		String colSname = obj.getString("colSname");
		String colType = obj.getString("colType");
		String colSubtype = obj.getString("colSubtype");
		String colStatus1 = obj.getString("colStatus1");
		String colStatus2 = obj.getString("colStatus2");
		String colStatus3 = obj.getString("colStatus3");
		int pageNum = obj.getIntValue("pageNum");
		int pageSize = obj.getIntValue("pageSize");
		PageHelper.startPage(pageNum, pageSize);
		List<TeacherProject2Map> projects = teacherProject2MapService.listAll(colTtime,colSname,colType,colSubtype,colStatus1,colStatus2,colStatus3);
		return getDataTable(projects);
	}
	
	@RequestMapping("addProject2")
	public Message addProject2(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse,
			@RequestBody TeacherProject2Map teacherProject2Map) {
		User user = (User)httpServletRequest.getSession().getAttribute("user");
		int flag = teacherProject2MapService.addProject2(user.getColCode(),teacherProject2Map);
		if(flag>0) {
			return Message.success();
		}else {
			return Message.error(1, "创建项目失败");
		}
	}
	
	public void findProjectBycolId(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse,
			@RequestBody String info){
		JSONObject obj = JSONObject.parseObject(info);
		int colId = obj.getIntValue("colId");
		TeacherProject2Map project = teacherProject2MapService.findBycolId(colId);
	}
	/**
	 * 检查项目编号是否存在
	 * @param info
	 * @return
	 */
	@RequestMapping("checkPnum")
	public Map<String,Object> checkPnum(@RequestBody String info) {
		Map<String,Object> map = new HashMap<>();
		JSONObject obj = JSONObject.parseObject(info);
		String colPnum = obj.getString("colPnum");
		int flag = teacherProject2MapService.checkPnum(colPnum);
		if(flag==0) {
			map.put("code", 0);
			return map;
		}else {
			map.put("code", 1);
			return map;
		}
	}
}
