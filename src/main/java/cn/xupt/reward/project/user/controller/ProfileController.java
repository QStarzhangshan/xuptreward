package cn.xupt.reward.project.user.controller;

import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

import cn.xupt.reward.common.constant.UserConstants;
import cn.xupt.reward.framework.service.EmailService;
import cn.xupt.reward.framework.web.domain.Message;
import cn.xupt.reward.project.user.domain.User;
import cn.xupt.reward.project.user.service.UserService;
import cn.xupt.reward.util.Md5Util;

/**
 * 个人信息修改
 * @author lebronzs
 *
 */
@RestController
public class ProfileController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private EmailService emailService;
	/**
	 * 修改密码
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @param info
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	@RequestMapping("updatePasswd")
	public Message updatePasswd(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse,
			@RequestBody String info) throws NoSuchAlgorithmException {
		//User user = (User) httpServletRequest.getSession().getAttribute("user");
		//Long colId = user.getColId();
		JSONObject obj = JSONObject.parseObject(info);
		Long colId = obj.getLong("colId");
		String oldPasswd = Md5Util.md5(obj.getString("oldPasswd"));
		String newPasswd = Md5Util.md5(obj.getString("newPasswd"));
		String newPasswd1 = Md5Util.md5(obj.getString("newPasswd1"));
		//String passwd = (String) httpServletRequest.getSession().getAttribute("passwd");
		/*if(!passwd.equals(oldPasswd)) {
			return Message.error(1, "原密码错误");
		}else*/ if(!newPasswd.equals(newPasswd1)) {
			return Message.error(2, "新密码不一致");
		}else if(oldPasswd==null||oldPasswd=="") {
			return Message.error(3, "原密码不能为空");
		}else if(newPasswd==null||newPasswd==""||newPasswd1==null||newPasswd1=="") {
			return Message.error(4, "新密码不能为空");
		}else {
			userService.updatePasswd(colId,newPasswd);
			return Message.success("修改密码成功");
		}
	}
	/**
	 * 完善个人信息
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @param user
	 * @return
	 */
	@RequestMapping("fillInfo")
	public Message fillInfo(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse,
			@RequestBody String info) {
		JSONObject obj = JSONObject.parseObject(info);
		User user1 = (User) httpServletRequest.getSession().getAttribute("user");
		String colEmail = obj.getString("colEmail");
		String colBankcard = obj.getString("colBankcard");
		String colIdcard = obj.getString("colIdcard");
		String colTelephone = obj.getString("colTelephone");
		Long userId = user1.getColId();
		if(!colIdcard.matches(UserConstants.ID_CARD_NUMBER_PATTERN)) {
			return Message.error(5, "身份证号格式错误");
		}else if(!colBankcard.matches(UserConstants.BANK_CARD_NUMBER_PATTERN)) {
			return Message.error(6, "银行卡格式错误");
		}else if(!colEmail.matches(UserConstants.EMAIL_PATTERN)) {
			return Message.error(7, "邮箱格式错误");
		}else if(!colTelephone.matches(UserConstants.MOBILE_PHONE_NUMBER_PATTERN)) {
			return Message.error(8, "手机号格式错误");
		}else if(userService.fillInfo(colEmail,colBankcard,colIdcard,colTelephone,userId)>0) {
			return Message.success("修改信息成功");
		}else {
			return Message.error();
		}
	}
	
	/**
	 * 通过邮件初始密码
	 * 
	 */
	@RequestMapping("sendMail")
	public Message sendHtmlMail(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse,
			@RequestBody String info) {
		JSONObject obj = JSONObject.parseObject(info);
		String colCode = obj.getString("colCode");
		String to = userService.findEmail(colCode);
		System.out.println(colCode);
		System.out.println(to);
		System.out.println(userService.findEmail(colCode));
		String content="<html>\n" +
                "<body>\n" +
                "    <a href=\"http://47.93.103.22/RuoYi\">重置密码</a>\n" +
                "</body>\n" +
                "</html>";
		if(to==null||to=="") {
			return Message.error(1, "请先填写工号");
		}else{
			User user = userService.findBycolCode(colCode);
			httpServletRequest.getSession().setAttribute("initUser",user);
			emailService.sendHtmlEmail(to, "急！重置密码", content);
		return Message.success();
		}
	}
	
	/**
	 * 一键初始密码
	 */
	@RequestMapping("initPasswd")
	public Message initPasswd(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) {
		User user = (User) httpServletRequest.getSession().getAttribute("initUser");
		try {
			user.setColPasswd(Md5Util.md5("123456"));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		if(userService.initPasswd(user)>0) {
			return Message.success("初始密码成功");
		}else {
			return Message.error(1, "初始密码失败");
		}
	}
}
