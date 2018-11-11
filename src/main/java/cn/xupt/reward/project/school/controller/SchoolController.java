package cn.xupt.reward.project.school.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.xupt.reward.project.school.domain.BaseSchool;
import cn.xupt.reward.project.school.domain.BaseSubSchool;
import cn.xupt.reward.project.school.service.SchoolService;
import cn.xupt.reward.project.school.service.SubSchoolService;
import cn.xupt.reward.project.user.domain.Teacher;
import cn.xupt.reward.project.user.domain.User;
import cn.xupt.reward.project.user.service.TeacherService;

@RestController
public class SchoolController {
	
	@Autowired
	private SchoolService schoolService;
	@Autowired
	private SubSchoolService subSchoolService;
	@Autowired
	private TeacherService teacherService;
	
	/**
	 * 根据身份查询所有一级学院
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @return
	 */
	@RequestMapping(value="AllSchool",method=RequestMethod.GET)
	public Map<String,Object> findSchool(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse){
		User user = (User)httpServletRequest.getSession().getAttribute("user");
		Teacher teacher = teacherService.findByCode(user.getColCode());
		Map<String,Object> map = new HashMap<String,Object>();
		List<BaseSchool> schools = null;
		if(user.getColRank()==4) {
			schools = schoolService.findAll();
			map.put("schools", schools);
			map.put("user", user);	
		}else {
			schools = schoolService.findOne(teacher.getColSchool());
			map.put("schools", schools);
			map.put("user", user);
		}
		return map;
	}
	/**
	 * 根据一级学院查询下列二级学院
	 * @param baseSchool
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @return
	 */
	@RequestMapping(value="AllSubSchool",method=RequestMethod.POST)
	public Map<String,Object> findDepartment(@RequestBody BaseSchool baseSchool,HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse){
		List<BaseSubSchool> subSchools = subSchoolService.findAllBySchool(baseSchool.getColSname());
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("subSchools", subSchools);
		return map;
	}
}
