package com.tmp.controller;

import java.sql.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.tmp.dto.BoardDTO;
import com.tmp.service.BoardServices;

@Controller
public class BoardController {

	@Autowired
	private BoardServices BoardServices;

	@RequestMapping(value = "/boardlist.do", method = RequestMethod.GET)
	public String selectAll(Model model) {
		List<BoardDTO> boardlist = BoardServices.selectAll();
		
		model.addAttribute("boardlist", boardlist);
		return "boardlist";
	}
	
	@RequestMapping(value = "/selectone", method = RequestMethod.GET)
	public String selectOne(Model model, HttpServletRequest request) throws Exception {
		String title = request.getParameter("title");
		
		BoardDTO board = BoardServices.selectOne(title);
		
		model.addAttribute("board", board);
		
		return "selectone";
	}
	
	@RequestMapping(value="writeboard.do")
	public String writeBoard() {
		return "writeboard";
	}

	@RequestMapping(value="/insertboard", method = {RequestMethod.GET, RequestMethod.POST})
	public String insertBoard(BoardDTO dto) {
		BoardServices.insertBoard(dto);
		System.out.println("저장 성공");
		
		return "forward:/boardlist.do";
	}
	
	@RequestMapping(value="/deleteboard.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String deleteBoard(HttpServletRequest request)throws Exception {
		String title = request.getParameter("title");
		BoardServices.deleteBoard(title);
		System.out.println(title);
		System.out.println("삭제 성공");
		
		return "redirect:/boardlist.do";
	}
	
	@RequestMapping(value="/updateboard.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String updateBoard(BoardDTO dto) {
		BoardServices.insertBoard(dto);
		System.out.println("수정 성공");
		
		return "redirect:/selectone.do";
	}
	
	@RequestMapping(value="/updatepage")
	public String updatePage(){
		System.out.println("수정 페이지");
		
		return "updatepage";
	}
	
}