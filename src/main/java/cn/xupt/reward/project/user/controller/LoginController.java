package cn.xupt.reward.project.user.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.google.code.kaptcha.impl.DefaultKaptcha;

import cn.xupt.reward.common.utils.StringUtils;
import cn.xupt.reward.framework.web.controller.BaseController;
import cn.xupt.reward.framework.web.domain.Message;
import cn.xupt.reward.project.user.domain.Teacher;
import cn.xupt.reward.project.user.domain.User;
import cn.xupt.reward.project.user.service.TeacherService;
import cn.xupt.reward.project.user.service.UserMenuService;
import cn.xupt.reward.project.user.service.UserService;


@Controller
@RequestMapping("/")
public class LoginController extends BaseController{

    @Autowired
    private UserService userService;
    @Autowired
    private TeacherService teacherSerivce;
    
    @Autowired
	private DefaultKaptcha defaultKaptcha;
    @Autowired
    private UserMenuService userMenuService;

    @PostMapping(value="/getlogin")
    @ResponseBody
    public Map<String,Object> login(
    		@RequestBody User user,
    		@RequestBody String v,
    		HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse
    ) {
    	Map<String,Object> map = new HashMap<String,Object>();
    	String captchaId = (String) httpServletRequest.getSession().getAttribute("vrifyCode");  
    	//v是json数组，拆分json，取属性名，拿到value
    	JSONObject obj = JSONObject.parseObject(v);
    	String vrifyCode = obj.getString("vrifyCode");
    	System.out.println("Session  vrifyCode "+captchaId+" form vrifyCode "+vrifyCode);
    	UsernamePasswordToken token = new UsernamePasswordToken(user.getColCode(), user.getColPasswd());
    	httpServletRequest.getSession().setAttribute("colCode", user.getColCode());
    	httpServletRequest.getSession().setAttribute("colPasswd", user.getColPasswd());
        System.out.println(httpServletRequest.getRequestedSessionId());
        Subject subject = SecurityUtils.getSubject();
        if(!vrifyCode.equals(captchaId)) {
        	map.put("code", 1);
        	return map;
        }else{
        try
        {
        	subject.login(token);
        	map.put("code", 0);
        	return map;
        }
        catch (AuthenticationException e)
        {
        	String msg = "用户或密码错误";
            if (StringUtils.isNotEmpty(e.getMessage()))
            {
            	msg = e.getMessage(); 
            }
            map.put("code", 2);
            return map;
        }
    }
    }

    /**
     * 返回用户菜单
     * @param info
     * @return
     */
	@RequestMapping("/getInfo")
	@ResponseBody
	public User selectperm(){
		System.out.println("------------------------------------");
		User user = (User)SecurityUtils.getSubject().getSession().getAttribute("userInfo");
		String colCode = user.getColCode();
		System.out.println(user.getColCode());
		User users = userMenuService.selectperm(colCode);
		return users;
	}
    
    
    /**
     * 退出登陆 页面需要转到登陆页面
     * @return
     */
    
    @RequestMapping("/logout")
    @ResponseBody
    public Message logout() {
    	Subject currentUser = SecurityUtils.getSubject();
    	currentUser.logout();
    	return Message.success("退出登陆成功");
    }
    

    
    /**
     * 验证码
     * @param httpServletRequest
     * @param httpServletResponse
     * @throws Exception
     */
	@RequestMapping(value="/defaultKaptcha",method = RequestMethod.GET)
	public void defaultKaptcha(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) throws Exception{
		 	byte[] captchaChallengeAsJpeg = null;  
	         ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();  
	         try {  
	         //生产验证码字符串并保存到session中
	         String createText = defaultKaptcha.createText();
	         httpServletRequest.getSession().setAttribute("vrifyCode", createText);
	         System.out.println(httpServletRequest.getSession().getAttribute("vrifyCode"));
	         System.out.println(httpServletRequest.getRequestedSessionId());
	         //httpServletResponse.sendRedirect("/getlogin");
	         //application.setAttribute("vrifyCode", createText);
	         //使用生产的验证码字符串返回一个BufferedImage对象并转为byte写入到byte数组中
             BufferedImage challenge = defaultKaptcha.createImage(createText);
             ImageIO.write(challenge, "jpg", jpegOutputStream);
	         } catch (IllegalArgumentException e) {  
	             httpServletResponse.sendError(HttpServletResponse.SC_NOT_FOUND);  
	               
	         } 
	         //定义response输出类型为image/jpeg类型，使用response输出流输出图片的byte数组
	         captchaChallengeAsJpeg = jpegOutputStream.toByteArray();  
	         httpServletResponse.setHeader("Cache-Control", "no-store");  
	         httpServletResponse.setHeader("Pragma", "no-cache");  
	         httpServletResponse.setDateHeader("Expires", 0);  
	         httpServletResponse.setContentType("image/jpeg");  
	         ServletOutputStream responseOutputStream =  
	                 httpServletResponse.getOutputStream();  
	         responseOutputStream.write(captchaChallengeAsJpeg);  
	         responseOutputStream.flush();  
	         responseOutputStream.close();
	       
	}
    
}
