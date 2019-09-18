package com.java.web.service;

import java.util.List;

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
}
