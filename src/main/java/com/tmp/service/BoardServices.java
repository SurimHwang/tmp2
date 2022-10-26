package com.tmp.service;

import com.tmp.dto.BoardContentDTO;
import com.tmp.dto.RereplyDTO;

import java.util.List;

public interface BoardServices {
	List<BoardContentDTO> selectAll();
	
	BoardContentDTO selectOne(int bno);
	
//	void insertBoard(BoardDTO dto);
	
	void deleteBoard(String title);
	
	void updateBoard(String title, String content);
	
	void insertbdContent(BoardContentDTO dtos);
	
	// 댓글 조회
	List<RereplyDTO> replyList(int bno);

	// 댓글 작성
	void replyWrite(RereplyDTO dto);

	// 댓글 수정
	void replyModify(RereplyDTO dto);

	// 댓글 삭제
	void replyDelete(RereplyDTO dto);
	
	int selectNextRno();
}
