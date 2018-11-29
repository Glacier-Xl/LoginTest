package com.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.model.Users;
import com.service.UsersService;

//@Controller("usersService")
@Controller
public class LoginController extends GenericController{
	//@Resource(name="usersService")这里的名字是usersServiceImpl的唯一标识@Service("usersService")
	@Resource
	private UsersService usersService;

	public void setUsersService(UsersService usersService) {
		this.usersService = usersService;
	}
	@RequestMapping("/LoginController_login.do")
	public ModelAndView login(Users users) {
		Users validate = this.usersService.loginValidate(users.getUsername());
		if(validate == null) {
			return new ModelAndView("login","error","用户名不存在");//为空，重新登录
		}else {
			if(validate.getPassword().equals(users.getPassword())) {
				this.session.setAttribute("validate", validate); 
				return new ModelAndView("index");//密码正确到Index界面
			}else {
				return new ModelAndView("login","error","密码错误");//密码不正确，到登录界面
			}
		}
	
		
	}
	
}
