package com.java.web;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
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
		System.out.println(req.getParameter("id")+", day :"+ req.getParameter("day"));
		String days = req.getParameter("day");
		String[] day =  days.split(",");
		for(String t : day) {
			System.out.println(t);
		}
	}
	
}
