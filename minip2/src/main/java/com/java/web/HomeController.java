package com.java.web;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
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

import com.java.web.DAO.AttendCheck;
import com.java.web.service.CheckService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	CheckService cs;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "home";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String home(HttpServletRequest req) {
		return "home";
	}
	
	@RequestMapping(value="/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping(value="/attendcheck", method=RequestMethod.POST)
	public void attendcheck(HttpServletRequest req) {
		System.out.println(req.getParameter("id")+", day :"+ req.getParameter("day")+": flag"+req.getParameter("flag"));
		cs.check(req);
		
	}
	
	@RequestMapping(value="/checkselect", method=RequestMethod.POST)
	public void checkselect(HttpServletResponse res , HttpSession session) {
		AttendCheck ac= new AttendCheck();
		try {
			res.setContentType("html/text; charset=utf-8");
			ac.setId((String)session.getAttribute("id"));
			List<AttendCheck> result =cs.checkselect(ac);
			
			res.getWriter().println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
