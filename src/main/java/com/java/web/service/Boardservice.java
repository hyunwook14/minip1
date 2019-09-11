package com.java.web.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.web.bean.BoardVO;

@Service
public class Boardservice {

	@Autowired
	SqlSession sqlsession;
	
	public void insert(BoardVO bvo) {
		if("".equals(bvo.getId())) {
			System.out.println("로그인이 필요합니다");
		}else {
			if("".equals(bvo.getTitle()) || "".equals(bvo.getComment())) {
				System.out.println("글을 작성할 수 없습니다.");
			}else {
				sqlsession.insert("mini.i_board", bvo);
			}
		}
	}
	
	public List<BoardVO> select() {
		List<BoardVO> result =sqlsession.selectList("mini.select_board");
		return result;
	}
	
	public int update(BoardVO bvo) {
		int result = sqlsession.update("mini.update_board", bvo);
		return result;
	}
	
	public int delete(BoardVO bvo) {
		int result = sqlsession.update("mini.delete_board", bvo);
		return result;
	}
	
}
