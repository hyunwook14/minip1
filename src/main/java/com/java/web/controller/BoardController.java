package com.java.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.java.web.bean.BoardVO;
import com.java.web.service.Boardservice;

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
	
	
	
	
}
