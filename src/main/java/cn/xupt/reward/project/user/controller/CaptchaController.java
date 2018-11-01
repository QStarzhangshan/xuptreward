package cn.xupt.reward.project.user.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.google.code.kaptcha.impl.DefaultKaptcha;

import cn.xupt.reward.framework.web.domain.Message;



/**
 * 图片验证码（支持算术形式）
 * @author ruoyi
 */
@Controller
@RequestMapping("/captcha")
@CrossOrigin
public class CaptchaController
{
	
	@RequestMapping("/imgvrifyControllerDefaultKaptcha")
	public int imgvrifyControllerDefaultKaptcha(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse){
		//ModelAndView andView = new ModelAndView();
		int vrify = 0; 
		 String captchaId = (String) httpServletRequest.getSession().getAttribute("vrifyCode");  
		 String parameter = httpServletRequest.getParameter("vrifyCode");
		 System.out.println("Session  vrifyCode "+captchaId+" form vrifyCode "+parameter);	 
		if (parameter==null||!captchaId.equals(parameter)) {
			vrify = 1;
			//andView.addObject("info", "错误的验证码");
			//andView.setViewName("index");
		} else {
			vrify = 2;
			//andView.addObject("info", "登录成功");
			//andView.setViewName("succeed");		
		}
		return vrify;
	}
}
