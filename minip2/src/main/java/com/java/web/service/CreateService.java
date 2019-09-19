package com.java.web.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.web.DAO.User;

@Service
public class CreateService {
	
	@Autowired
	SqlSession sqlsession;
	
	public int createuser(User user) {
		int result =0;
		
		System.out.println(user.toString());
		if(!"".equals(user.getId()) && "".equals(user.getPwd())) {
			
			result = sqlsession.insert("calendar.c_user", user);
		}else {
			System.out.println("null 값으로 insert 예외처리");
		}
		
		return result;
	}
}
