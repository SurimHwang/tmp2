package com.tmp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tmp.dto.RereplyDTO;
import com.tmp.service.BoardServices;

@Controller
public class ReplyController {
	
	@Autowired
	private BoardServices boardServices;

	// 댓글 작성
	@RequestMapping(value = "/replyWrite", method = RequestMethod.GET)
	public String replyWrite(RereplyDTO dto, Model model) {
			
		boardServices.replyWrite(dto);
		
		return "redirect:/selectone?bno=" + dto.getBno();
	}
	
	@RequestMapping(value="/rereplyWrite", method= {RequestMethod.GET, RequestMethod.POST})
	public String rereplyWrite(int bno, String writer, String contents, int parentId, int depth) {
		
		RereplyDTO dto = new RereplyDTO();
		
		dto.setBno(bno);
		dto.setWriter(writer);
		dto.setContents(contents);
		dto.setParentId(parentId);
		dto.setDepth(depth);
		
		boardServices.replyWrite(dto);
		
		
		return "redirect:/selectone?bno=" + dto.getBno();
	}
	
	// 댓글 변경
		@RequestMapping(value = "/replyModify", method = RequestMethod.GET)
		public String replyModify(@RequestParam(value="bno", required=false)int bno, RereplyDTO dto) {
			
			System.out.println(dto.getRno());
			System.out.println(dto.getBno());
			
			boardServices.replyModify(dto);
			
			return "redirect:/selectone?bno=" + dto.getBno();
		}
		
		// 댓글 삭제
		@RequestMapping(value = "/replyDelete", method = RequestMethod.GET)
		public String replyDelete(RereplyDTO dto) {
			
			boardServices.replyDelete(dto);
			
			return "redirect:/selectone?bno=" + dto.getBno();
		}

}
