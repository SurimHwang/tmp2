package com.tmp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmp.dao.BoardDAO;
import com.tmp.dto.BoardContentDTO;
import com.tmp.dto.RereplyDTO;
import com.tmp.service.BoardServices;
import java.sql.Date;
import java.time.Instant;

@Service
public class BoardServicesImpl implements BoardServices {

	@Autowired
	private BoardDAO boardDAO;

	public List<BoardContentDTO> selectAll() {
		List<BoardContentDTO> dao = boardDAO.selectAll();
		return dao;
	}
	
	public BoardContentDTO selectOne(int bno){
		return boardDAO.selectOne(bno);
		
	}; 
	
//	public void insertBoard(BoardDTO dto) {
//		boardDAO.insertBoard(dto);
//	}
	
	public void deleteBoard(String title) {
		boardDAO.deleteBoard(title);
	}
	
	public void updateBoard(String title, String content) {
		boardDAO.updateBoard(title, content);
	}
	
	public void insertbdContent(BoardContentDTO dto) {
		boardDAO.insertbdContent(dto);
	}
	
	public List<RereplyDTO> replyList(int bno){
		return boardDAO.replyList(bno);
	};

	// 댓글 작성
	public void replyWrite(RereplyDTO dto) {
		boardDAO.replyWrite(dto);
	};

	// 댓글 수정
	public void replyModify(RereplyDTO dto) {
		boardDAO.replyModify(dto);
	};

	// 댓글 삭제
	public void replyDelete(RereplyDTO dto) {
		boardDAO.replyDelete(dto);
	};
	public int selectNextRno() {
		return boardDAO.selectNextRno();
	}
}
