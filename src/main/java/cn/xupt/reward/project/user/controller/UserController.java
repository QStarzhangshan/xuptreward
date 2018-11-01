package cn.xupt.reward.project.user.controller;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.xupt.reward.common.constant.UserConstants;
import cn.xupt.reward.framework.web.controller.BaseController;
import cn.xupt.reward.framework.web.domain.Message;
import cn.xupt.reward.project.user.domain.Permission;
import cn.xupt.reward.project.user.domain.Teacher;
import cn.xupt.reward.project.user.domain.User;
import cn.xupt.reward.project.user.service.PermissionService;
import cn.xupt.reward.project.user.service.TeacherService;
import cn.xupt.reward.project.user.service.UserService;
import cn.xupt.reward.util.Md5Util;

@Controller
public class UserController extends BaseController{

	@Autowired
	private UserService userService;
	@Autowired
	private TeacherService teacherSerivce;
	@Autowired
	private PermissionService permissionService;
	
	
	@RequiresPermissions("system:user:management")
	@RequestMapping(value="findAll")
	@ResponseBody
	public List<User> userList() {
		List<User> users = userService.findAll();
		return users;
		
	}
	/**
	 * 主页面
	 * @param colCode
	 * @param colPasswd
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @return
	 */
	
	@RequestMapping(value="home")
	@ResponseBody
	public User home(String colCode,String colPasswd,HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) {
		colCode = (String) httpServletRequest.getSession().getAttribute("colCode");
		colPasswd = (String) httpServletRequest.getSession().getAttribute("colPasswd");
		User user = userService.selectUserByColCode(colCode, colPasswd);
		httpServletRequest.getSession().setAttribute("user", user);
		return user;
		
	}
	
	
	/**
	 * 添加用户
	 */
	@RequestMapping(value="insertUser",method=RequestMethod.POST)
	@ResponseBody
	public Message insertUser(@RequestBody User user,@RequestBody Teacher teacher) {
		String a = checkColCode(user);
		if(a=="1") {
			System.out.println("000");
			return Message.error(1, "工号已存在");
		}else if(user.getColCode()==null||user.getColCode()==""){
			System.out.println("111");
			return Message.error(2, "工号不能为空");
		}else if(!user.getColCode().matches(UserConstants.COL_CODE_PATTERN)) {
			System.out.println("222");
			return Message.error(3, "工号格式错误");
		}else if(user.getColName()==null||user.getColName()=="") {
			System.out.println("333");
			return Message.error(4, "姓名不能为空");
		}else if(!user.getColEmail().matches(UserConstants.EMAIL_PATTERN)){
			System.out.println("444");
			return Message.error(5, "邮箱格式错误");
		}else if(!user.getColTelephone().matches(UserConstants.MOBILE_PHONE_NUMBER_PATTERN)) {
			System.out.println("555");
			return Message.error(6, "手机号格式错误");
		}else {
			user.setColCode(user.getColCode());
			try {
				user.setColPasswd(Md5Util.md5("123456"));
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			user.setColName(user.getColName());
			user.setColEmail(user.getColEmail());
			user.setColTelephone(user.getColTelephone());
			user.setColSex(user.getColSex());
			user.setColEducation(user.getColEducation());
			user.setColRank(user.getColRank());
			teacher.setColCode(user.getColCode());
			teacher.setColTitle(teacher.getColTitle());
			teacher.setColSchool(teacher.getColSchool());
			teacher.setColDepartment(teacher.getColDepartment());
			teacher.setColDuty(teacher.getColDuty());
			teacher.setColJobtype(teacher.getColJobtype());
			teacher.setColJobname(teacher.getColJobname());
			teacher.setColJobclass(teacher.getColJobclass());
			System.out.println(teacher.getColDepartment());
			teacherSerivce.insertTeacher(teacher);
			userService.insertUser(user);
			return Message.success("注册成功");
		}
	}
	
	/**
	 * 校验工号是否唯一
	 */
	@RequestMapping(value="checkColCode",method=RequestMethod.POST)
	@ResponseBody
	public String checkColCode(User user) {
		String uniqueFlag = "0";
		if(user.getColCode()!=null) {
			uniqueFlag = userService.checkColCode(user.getColCode());
		}
		return uniqueFlag;
	}
	/**
	 * 查询用户权限
	 * @param colId
	 * @return
	 */
	@RequestMapping(value="selectpers/{colId}")
	@ResponseBody
	public Set<String> selectpers(@PathVariable("colId") Long colId){
		System.out.println("------colId");
		Set<String> pers =permissionService.selectPermissionBycolId(colId);
		
		return pers;
	}
	
}
