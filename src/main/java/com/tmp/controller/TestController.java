package com.tmp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tmp.dto.TestDTO;
import com.tmp.service.TestServices;

@Controller
public class TestController {

	@Autowired
	private TestServices testServices;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(Model model, TestDTO dto, HttpSession session) {

		TestDTO ts = testServices.login(dto);
		
		if (ts!=null) {
			TestDTO login = testServices.login(dto);

			model.addAttribute("user", login);
			
			System.out.println("로그인");
			
			session.setAttribute("user", login);
			
			TestDTO dto_ = (TestDTO)session.getAttribute("user");
			session.setAttribute("userName", dto_.getUserName()); 

			System.out.println(dto_.getUserName());
			return "forward:/boardlist.do";
		}
		return "redirect:/";
	}

	@RequestMapping(value = "/signUp", method = RequestMethod.POST)
	public String signUp(TestDTO dto) {

		testServices.signUp(dto);

		System.out.println("회원 가입 성공.");

		return "sample";
	}

	@RequestMapping(value = "/updateUserName", method = RequestMethod.POST)
	public String updateUserName(TestDTO dto) {

		testServices.updateUserName(dto);

		System.out.println("사용자 이름 수정 성공.");

		return "sample";
	}

	@RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
	public String deleteUser(TestDTO dto) {

		testServices.deleteUser(dto);

		System.out.println("사용자 삭제 성공.");

		return "sample";
	}

}