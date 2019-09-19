package com.java.web.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.web.DAO.AttendCheck;

@Service
public class CheckService {
	
	@Autowired
	SqlSession sqlsession;
	
	public void check(HttpServletRequest req) {
		AttendCheck ac = new AttendCheck();
		List<AttendCheck> result;
		int insertresult = 0;
		int updateresult = 0;
		
		String id = req.getParameter("id");
		ac.setId(id);
		
		String day = req.getParameter("day");
		ac.setDay(Integer.parseInt(day));
		
		String checkflag = req.getParameter("flag");
		System.out.println("checkflag: "+ checkflag);
		
		if("true".equals(checkflag)) ac.setCheck(1);
		else ac.setCheck(0);
		
		result = checkselect(ac);
		
		if( result.size() == 0) {
			System.out.println("값 존재 x");
			insertresult = sqlsession.insert("calendar.checkinsert", ac);
		}else {
			
			updateresult=sqlsession.update("calendar.checkupdate", ac);
		}
		
		System.out.println(insertresult+"-- 입력결과, "+updateresult+"-- 업데이트결과");
	}
	
	public List<AttendCheck> checkselect(AttendCheck ac) {
		return sqlsession.selectList("calendar.checkselect", ac);
	}
	
	public int checkupdate(AttendCheck ac) {
		return sqlsession.update("calendar.checkupdate", ac);
	}
	
	public List<AttendCheck> checkperson(int no) {
		return sqlsession.selectList("calendar.checkperson", no);
	}
	
}
