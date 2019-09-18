package com.java.web.controller;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.java.web.bean.BoardVO;
import com.java.web.service.Boardservice;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	Boardservice bs;
	
	@Autowired
	SqlSession sqlsession;
	
	@RequestMapping("")
	public String board(HttpServletRequest req, HttpSession session) {
		if(session.getAttribute("user") == null) return "redirect:/";
		List<BoardVO> result = bs.select();
		req.setAttribute("list", result);
		return "board";
	}
	
	@RequestMapping(value="/create",method=RequestMethod.POST)
	public String create(BoardVO bvo, HttpSession session) {
		System.out.println("시작");
		bvo.setId((String)session.getAttribute("user"));
		bs.insert(bvo);
		return "redirect:/board";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public void update(BoardVO bvo, HttpServletResponse res, HttpSession session) {
		System.out.println( bvo.toString());
		int result = 0;
		System.out.println(session.getAttribute("user")+","+ bvo.getId());
		if(session.getAttribute("user").equals(bvo.getId()))	result = bs.update(bvo);
		System.out.println("성공여부: "+result);
		
		
		try {
			res.setContentType("text/plan; charset=utf-8");
//			res.setHeader("Content-type", "text/html");
			res.getWriter().append(result + "");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public void delete(BoardVO bvo, HttpSession session, HttpServletResponse res) {
		System.out.println("삭제 시작");
		System.out.println(bvo.toString() +", "+ session.getAttribute("user"));
		int result =0;
		if(session.getAttribute("user").equals(bvo.getId())) {
			System.out.println("서비스시작");
			result = bs.delete(bvo);
		}
		System.out.println("삭제결과: "+ result);
		try {
			res.setContentType("text/html; charset=utf-8");
			res.getWriter().append(result + "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
