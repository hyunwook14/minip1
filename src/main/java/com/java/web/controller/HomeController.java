package com.java.web.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.java.web.bean.User;
import com.java.web.service.Userservice;
@Controller
public class HomeController {
	
	@Autowired
	Userservice us;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "home";
	}
	
	@RequestMapping(value="/c_user")
	public String c_user() {
		return "c_user";
	}
	
	@RequestMapping(value="/c_user", method=RequestMethod.POST)
	public String c_user(HttpServletRequest req, HttpServletResponse res, User user) {
		if(("").equals(user.getId())) {
			System.out.println("아이디값이 없습니다");
			if(("").equals(user.getPwd())) return "redirect:/c_user";
			else return "redirect:/c_user";
		}else {
			int result = us.creatuser(user); 
		}
		return "redirect:/";
	}
	
	@RequestMapping(value="/logincheck", method=RequestMethod.POST)
	public String logincheck(HttpSession session, User user) {
		
		System.out.println("User 체크시작 ");
		boolean result =us.check_user(user);
		System.out.println("로그인여부: "+ result);
		if(result) {
			session.setAttribute("user", user.getId());
			return "redirect:/board";
		}
		else {
			System.out.println("로그인오류");
		}
		
		return "redirect:/";
	}
	
	
}
