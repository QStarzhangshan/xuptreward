package cn.xupt.reward.project.user.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.code.kaptcha.impl.DefaultKaptcha;

import cn.xupt.reward.common.utils.StringUtils;
import cn.xupt.reward.framework.web.controller.BaseController;
import cn.xupt.reward.framework.web.domain.Message;
import cn.xupt.reward.project.user.service.UserService;


@Controller
@RequestMapping("/")
public class LoginController extends BaseController{

    @Autowired
    private UserService userService;
    
    @Autowired
	private DefaultKaptcha defaultKaptcha;

    @PostMapping(value="/getlogin")
    @ResponseBody
    public Message login(
            @RequestParam(required = false) String colCode,
            @RequestParam(required = false) String colPasswd,
            HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse
    ) {
		 String captchaId = (String) httpServletRequest.getSession().getAttribute("vrifyCode");  
		 String parameter = httpServletRequest.getParameter("vrifyCode");
		 System.out.println("Session  vrifyCode "+captchaId+" form vrifyCode "+parameter);
    	UsernamePasswordToken token = new UsernamePasswordToken(colCode, colPasswd);
    	httpServletRequest.getSession().setAttribute("colCode", colCode);
    	httpServletRequest.getSession().setAttribute("colPasswd", colPasswd);
       // System.out.println(colCode);
       //System.out.println(colPasswd);
       //System.out.println((String)httpServletRequest.getSession().getAttribute("vrifyCode"));
       //System.out.println(httpServletRequest.getParameter("vrifyCode"));
       // System.out.println(httpServletRequest.getRequestedSessionId());
        Subject subject = SecurityUtils.getSubject();
        if(!parameter.equals(captchaId)) {
        	return Message.error(2, "验证码错误");
        }else {
        try
        {
        	subject.login(token);
            return Message.success("登陆成功");//code为0
        }
        catch (AuthenticationException e)
        {
        	String msg = "用户或密码错误";
            if (StringUtils.isNotEmpty(e.getMessage()))
            {
            	msg = e.getMessage(); 
            }
            return Message.error(msg);
        }
    }
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
