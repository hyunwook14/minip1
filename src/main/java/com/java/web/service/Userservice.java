package com.java.web.service;

import java.util.ArrayList;
import java.util.List;

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
	
	public boolean check_user(User user) {
		List<User> userlist = new ArrayList<User>();
		boolean idflag= false;
		if("".equals(user.getId())){
			System.out.println("아이디 입력이 필요합니다");
		}else if("".equals(user.getPwd())) {
			System.out.println("비밀번호 입력이 필요합니다.");
		}else {
			System.out.println("아이디검사");
			userlist = sqlsession.selectList("mini.check_user", user);
			System.out.println(userlist.size());
			if(userlist.size() != 0) idflag=true;
		}
		
		return idflag;
	}
	
}
