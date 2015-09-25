package com.ykb.proto.controller;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ykb.proto.pojo.User;
import com.ykb.proto.service.impl.UserServiceImpl;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserServiceImpl userServiceImpl;
	
	@RequestMapping("/test")
	public ModelAndView test1() {
		return new ModelAndView("user/test");
	}
	
	@RequestMapping("/register")
	public ModelAndView register() {
		return new ModelAndView("user/user_register");
	}
	
	@RequestMapping("/register/submit")
	public ModelAndView registerSubmit(HttpServletRequest request) {
		User user = new User();
		long id = new Random().nextLong();
		user.setId(id);
		user.setName(request.getParameter("user_name"));
		user.setPassword(request.getParameter("user_password"));
		boolean success = userServiceImpl.register(user);
		if (success)
			return new ModelAndView("user/user_register_result", "user_register_result", "success");
		return new ModelAndView("user/user_register_result", "user_register_result", "fail");
	}

}
