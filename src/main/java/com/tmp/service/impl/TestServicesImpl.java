package com.tmp.service.impl;

import com.tmp.dao.TestDAO;
import com.tmp.dto.TestDTO;
import com.tmp.service.TestServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServicesImpl implements TestServices {

	@Autowired
	private TestDAO testDAO;

	public List<TestDTO> login(TestDTO dto) {
		List<TestDTO> dao = testDAO.login(dto);
		if (dao != null) {
			return dao;
		}

		System.out.println(dao + "null");
		return null;

	}

	public void signUp(TestDTO dto) {
		testDAO.signUp(dto);
	}

	public void updateUserName(TestDTO dto) {
		testDAO.updateUserName(dto);
	}

	public void deleteUser(TestDTO dto) {
		testDAO.deleteUser(dto);
	}
}
