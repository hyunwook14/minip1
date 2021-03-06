package com.java.web.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.java.web.DAO.User;
import com.java.web.service.CreateService;
import com.java.web.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	LoginService ls;
	
	@Autowired
	CreateService cs;
	
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
	
	@RequestMapping(value="/c_user", method = RequestMethod.GET)
	public String c_user() {
		return "c_user";
	}
	
	@RequestMapping(value="/idcheck", method = RequestMethod.POST)
	public void idcheck(HttpServletRequest req, HttpServletResponse res) {
		try {
			int result =ls.idcheck(req);
			res.setContentType("text/html; charset=utf-8");
			res.getWriter().append(result+"");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/create_u", method=RequestMethod.POST)
	public void create_u(HttpServletResponse res, User user) {
		try {
			res.setContentType("text/html; charset=utf-8");
			int result = cs.createuser(user);
			if(result == 1 ) res.getWriter().print("<script>alert('회원가입성공'); location.href='/minip2/login' </script>");
			else res.getWriter().print("<script>alert('회원가입실패'); location.href='/minip2/c_user' </script>"); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
