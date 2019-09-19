package com.java.web.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.java.web.DAO.User;
import com.java.web.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	LoginService ls;
	
	@RequestMapping( value="/logincheck", method=RequestMethod.POST)
	public void logincheck(User user, HttpServletResponse res, HttpSession session) {
		try {
		res.setContentType("text/html; charset=utf-8"); 
		PrintWriter out = res.getWriter();	
		
		boolean result =ls.login(user, session);
		
		if(result) {
			out.print("<script>location.href='/minip2/'</script>");
		}
			String msg ="<script>alert('로그인실패');location.href='/minip2/login'</script>";
			out.print(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void loginsession(HttpSession session) {
		
		
	}
	
}
