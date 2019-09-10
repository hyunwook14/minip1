package com.java.web.service;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.web.bean.User;

@Service
public class Userservice {
	
	@Autowired
	SqlSession sqlsession;
	
	
	
	public int creatuser(User user) {
		int result = 0;
		result = sqlsession.insert("mini.c_user", user);
		return result;
	}
	
	
}
