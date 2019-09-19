package com.java.web.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.web.DAO.User;

@Service
public class LoginService {
	
	@Autowired
	SqlSession sqlsession;
	
	public boolean login(User user, HttpSession session) {
		boolean loginflag =false;
		List<User> result=sqlsession.selectList("calendar.logincheck", user);
		
		if(result.size() ==1) {
			loginflag= true;
			session.setAttribute("id", result.get(0).getId());
		}
		
		return loginflag;
	}
	
	public int idcheck(HttpServletRequest req) {
		String id = req.getParameter("id");
		System.out.println(id+"--- id");
		int result = 0;
		if(sqlsession.selectOne("calendar.idcheck", id) == null) {
			System.out.println("select 값 null");
		}else {
			User Userresult =sqlsession.selectOne("calendar.idcheck", id);
			if(Userresult != null) result = 1;
			System.out.println(Userresult.getId());
		}
		
		return result;
	}
	
}
