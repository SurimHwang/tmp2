package com.tmp.service;

import com.tmp.dto.BoardContentDTO;
import com.tmp.dto.BoardDTO;

import java.util.List;

public interface BoardServices {
	List<BoardDTO> selectAll();
	
	BoardDTO selectOne(String title);
	
	void insertBoard(BoardDTO dto);
	
	void deleteBoard(String title);
	
	void updateBoard(String title, String content);
	
	void insertbdContent(BoardContentDTO dtos);
}
