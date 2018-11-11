package cn.xupt.reward.project.user.controller;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;

import cn.xupt.reward.common.constant.UserConstants;
import cn.xupt.reward.framework.web.controller.BaseController;
import cn.xupt.reward.framework.web.domain.Message;
import cn.xupt.reward.framework.web.page.TableDataInfo;
import cn.xupt.reward.project.user.domain.Teacher;
import cn.xupt.reward.project.user.domain.User;
import cn.xupt.reward.project.user.domain.UserRole;
import cn.xupt.reward.project.user.service.PermissionService;
import cn.xupt.reward.project.user.service.TeacherService;
import cn.xupt.reward.project.user.service.UserRoleService;
import cn.xupt.reward.project.user.service.UserService;
import cn.xupt.reward.util.Md5Util;

@Controller
@RequestMapping("/user")
@RestController
public class UserController extends BaseController{

	@Autowired
	private UserService userService;
	@Autowired
	private TeacherService teacherSerivce;
	@Autowired
	private PermissionService permissionService;
	@Autowired
	private UserRoleService userroleService;
	
	/**
	 * 主页面,识别身份
	 * @param colCode
	 * @param colPasswd
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @return
	 */
	
	@RequestMapping(value="home")
	public Map<String,Object> home(String colCode,String colPasswd,HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) {
		Map<String,Object> map = new HashMap<String,Object>();
		colCode = (String) httpServletRequest.getSession().getAttribute("colCode");
		colPasswd = (String) httpServletRequest.getSession().getAttribute("colPasswd");
		User user = userService.selectUserByColCode(colCode, colPasswd);
		Teacher teacher = teacherSerivce.findByCode(colCode);
		map.put("user", user);
		map.put("teacher", teacher);
		httpServletRequest.getSession().setAttribute("user", user);
		httpServletRequest.getSession().setAttribute("teacher", teacher);
		return map;
	}
		
	/**
	 * 用户管理
	 * @param baseSubSchool
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @return
	 */
	@RequiresPermissions("system:user:management")
	@RequestMapping(value="/findAll")
	public TableDataInfo userList(@RequestBody String info,HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) {
		//Map<String,Object> map = new HashMap<String,Object>();
		JSONObject obj = JSONObject.parseObject(info);
		String colSname = obj.getString("colSname");
		String colDname = obj.getString("colDname");
		int pageNum = obj.getIntValue("pageNum");
		int pageSize = obj.getIntValue("pageSize");
		System.out.println(colSname);
		System.out.println(colDname);
		System.out.println(pageNum);
		System.out.println(pageSize);
		//分页一般格式，先继承basecontroller，用父类的getdataTable方法，可以避免中文乱码问题
		//分页注入的依赖是pagehelper-spring-boot-starter 不是pagehelper
		PageHelper.startPage(pageNum, pageSize);
		List<User> users = userService.findAll(colSname,colDname);
		//return JSON.toJSONString(users);
		return getDataTable(users);
	}
	
	/**
	 * 点击用户
	 */
	
	@RequestMapping("findBycolCode")
	public void findBycolCode(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse,
			@RequestBody String info){
		JSONObject obj = JSONObject.parseObject(info);
		String colCode = obj.getString("colCode");
		System.out.println(colCode);
		User  user = userService.findBycolCode(colCode);
		Teacher teacher = teacherSerivce.findByCode(colCode);
		httpServletRequest.getSession().setAttribute("userBycolCode", user);
		httpServletRequest.getSession().setAttribute("teacherBycolCode", teacher);
		System.out.println(user);
		System.out.println(teacher);
	}
	/**
	 * 显示用户基本信息
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @return
	 */
	@RequestMapping("userView")
	public Map<String,Object> userView(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse){
		Map<String,Object> map = new HashMap<String,Object>();
		User user = (User) httpServletRequest.getSession().getAttribute("userBycolCode");
		Teacher teacher = (Teacher) httpServletRequest.getSession().getAttribute("teacherBycolCode");
		map.put("users", user);
		map.put("teachers", teacher);
		return map;
	}
	
	@RequiresPermissions("system:user:updateButton")
	@RequestMapping("updateButton")
	public Message updateButton(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) {
		User user = (User) httpServletRequest.getSession().getAttribute("user");
		if(user.getColRank()==1||user.getColRank()==4||user.getColRank()==3) {
			return Message.success("进入修改用户页面");
		}else {
			return Message.error(1, "您没有权限修改");
		}
	}
	
	/**
	 * 修改用户
	*/
	@RequiresPermissions("system:user:update")
	@RequestMapping(value="updateUser",method=RequestMethod.POST)
	public Message modifyUser(@RequestBody String info,HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) {
		User user = (User) httpServletRequest.getSession().getAttribute("user");
		User user1 = (User) httpServletRequest.getSession().getAttribute("userBycolCode");
		Teacher teacher1 = (Teacher) httpServletRequest.getSession().getAttribute("teacherBycolCode");
		JSONObject obj = JSONObject.parseObject(info);
		String colSchool =(String)obj.get("colSchool");
		String colDepartment =(String)obj.get("colDepartment");
		String colTitle =(String)obj.get("colTitle");
		String colDuty =(String)obj.get("colDuty");
		String colJobtype =(String)obj.get("colJobType");
		String colJobname =(String)obj.get("colJobName");
		String colJobclass =(String)obj.get("colJobClass");
		Long colRank = (Long)obj.get("colRank");
		if(user.getColRank().longValue()==1) {   //人事处只能修改基本信息
			teacher1.setColSchool(colSchool);
			teacher1.setColDepartment(colDepartment);
			teacher1.setColTitle(colTitle);
			teacher1.setColDuty(colDuty);
			teacher1.setColJobtype(colJobtype);
			teacher1.setColJobname(colJobname);
			teacher1.setColJobclass(colJobclass);
			teacherSerivce.updateTeacher(teacher1);
			return Message.success("修改用户信息成功");
		}else if(user.getColRank()==3&&user.getColRank().longValue()>user1.getColRank().longValue()) { //一级学院领导赋予权限，去管理科研项目
			user1.setColRank(colRank);
			userService.updateUserRank(user1);
			userroleService.updateUserRole(user1);                                                                                                       
			return Message.success("修改用户权限成功");
		}else {   //超管
			teacher1.setColSchool(colSchool);
			teacher1.setColDepartment(colDepartment);
			teacher1.setColTitle(colTitle);
			teacher1.setColDuty(colDuty);
			teacher1.setColJobtype(colJobtype);
			teacher1.setColJobname(colJobname);
			teacher1.setColJobclass(colJobclass);
			user1.setColRank(colRank);
			teacherSerivce.updateTeacher(teacher1);
			userService.updateUserRank(user1);
			return Message.success("全部修改");
		}
	} 
	@RequiresPermissions("system:user:addButton")
	@RequestMapping("addButton")
	public Message addButton(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) {
		User user = (User) httpServletRequest.getSession().getAttribute("user");
		if(user.getColRank()==1||user.getColRank()==4) {
			return Message.success("进入添加用户页面");
		}else {
			return Message.error(1, "您没有权限添加");
		}
	}
	
	/**
	 * 添加用户
	 */
	@RequiresPermissions("system:user:add")
	@RequestMapping(value="addUser",method=RequestMethod.POST)
	public Message insertUser(@RequestBody User user,@RequestBody Teacher teacher) {
		UserRole userrole = new UserRole();
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
		}else if(teacher.getColSchool()==null||teacher.getColSchool()==""){
			return Message.error(7, "学院不能为空");
		}else if(teacher.getColDepartment()==null||teacher.getColDepartment()=="") {
			return Message.error(8, "部门不能为空");
		}else {
			//user.setColCode(user.getColCode()); //教工号
			try {
				user.setColPasswd(Md5Util.md5("123456")); //密码默认123456
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//user.setColName(user.getColName()); //姓名
			//user.setColSex(user.getColSex()); //性别
			//user.setColTime(user.getColTime()); //报到时间
			user.setColRank((long) 0);
			//teacher.setColCode(user.getColCode());
			//teacher.setColSchool(teacher.getColSchool()); //学院
			//teacher.setColDepartment(teacher.getColDepartment()); //部门
			teacherSerivce.insertTeacher(teacher);
			userService.insertUser(user);
			userrole.setRoleId((long) 4);
			userroleService.insert(userrole);
			return Message.success("添加用户成功");
		}
	}
	@RequiresPermissions("system:user:delete")
	@RequestMapping("deleteUser")
	public Message deleteUser(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse,
			@RequestBody String col) {
		JSONObject obj = JSONObject.parseObject(col);
		Long colId = obj.getLong("colId");
	    if(userService.deleteBycolId(colId)>0&&teacherSerivce.deleteBycolId(colId)>0&&userroleService.deleteBycolId(colId)>0) {
	    	 return Message.success("删除用户成功");
	    }else {
	    	return Message.error(1, "删除用户失败");
	    }
	}
	
	/**
	 * 校验工号是否唯一
	 */
	@RequestMapping(value="checkColCode",method=RequestMethod.POST)
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
	public Set<String> selectpers(@PathVariable("colId") Long colId){
		System.out.println("------colId");
		Set<String> pers =permissionService.selectPermissionBycolId(colId);
		return pers;
	}	
}
