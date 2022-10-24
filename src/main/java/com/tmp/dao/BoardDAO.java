package com.tmp.dao;

import java.util.List;

import com.tmp.dto.BoardContentDTO;
import com.tmp.dto.BoardDTO;

public interface BoardDAO {

	List<BoardDTO> selectAll(); //게시판 리스트 출력
	
	BoardDTO selectOne(String title); //게시글 한 개 보기 
	
	void insertBoard(BoardDTO dto); //게시판 글쓰기
	
	void deleteBoard(String title); //게시글 삭제
	
	void updateBoard(String title, String content); //게시글 수정
	
	void insertbdContent(BoardContentDTO dto);
}
