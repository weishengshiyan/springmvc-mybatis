package com.ls.springmvc.controller;

import javax.servlet.http.HttpSession;import org.apache.logging.log4j.core.jmx.AppenderAdmin;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ls.springmvc.pojo.User;

@Controller
@RequestMapping("user")
public class LoginCotroller {
	
	@RequestMapping("tologin")
	public String tologin() {

		return "login";
	}
	@RequestMapping("login")
	public String login(String username,String password,HttpSession session) {
		

		if (username.equals("admin")){
			
			session.setAttribute("username",username);
			return "redirect:/itemList.action";
		}
		
		return "login";
		
		
		
		
	}
		
	}

	


