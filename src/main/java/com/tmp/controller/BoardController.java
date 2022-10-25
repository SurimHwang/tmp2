package com.tmp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tmp.dto.BoardContentDTO;
import com.tmp.dto.RereplyDTO;
import com.tmp.service.BoardServices;

@Controller
public class BoardController {

	@Autowired
	private BoardServices BoardServices;

	@RequestMapping(value = "/boardlist.do", method = {RequestMethod.GET,RequestMethod.POST})
	public String selectAll(Model model) {
		List<BoardContentDTO> boardlist = BoardServices.selectAll();
		
		model.addAttribute("boardlist", boardlist);
		return "boardlist";
	}
	
	@RequestMapping(value = "/selectone", method = {RequestMethod.GET, RequestMethod.POST})
	public String selectOne(Model model, HttpServletRequest request) throws Exception {
		int bno = Integer.parseInt(request.getParameter("bno"));		
		
		BoardContentDTO board = BoardServices.selectOne(bno);
		
		model.addAttribute("board", board);
		
		// 댓글 리스트 조회
		List<RereplyDTO> reply = BoardServices.replyList(bno);
		model.addAttribute("reply", reply);

		return "selectone";
	}
	
	@RequestMapping(value="writeboard.do")
	public String writeBoard() {
		return "writeboard";
	}

//	@RequestMapping(value="/insertboard", method = {RequestMethod.GET, RequestMethod.POST})
//	public String insertBoard(BoardDTO dto) {
//		BoardServices.insertBoard(dto);
//		System.out.println("저장 성공");
//		
//		return "forward:/boardlist.do";
//	}
	
	@RequestMapping(value="/deleteboard.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String deleteBoard(HttpServletRequest request)throws Exception {
		String title = request.getParameter("title");
		BoardServices.deleteBoard(title);
		System.out.println("삭제 성공");
		
		return "redirect:/boardlist.do";
	}
	
//	@RequestMapping(value="/updateboard.do", method = {RequestMethod.GET, RequestMethod.POST})
//	public String updateBoard(BoardDTO dto) {
//		BoardServices.insertBoard(dto);
//		System.out.println("수정 성공");
//		
//		return "redirect:/selectone.do";
//	}
	
	@RequestMapping(value="/updatepage", method = {RequestMethod.GET, RequestMethod.POST})
	public String updatePage(Model model, HttpServletRequest request) throws Exception{
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		//model.addAttribute();
		System.out.println("수정 페이지");
		
		return "updatepage";
	}
	
}