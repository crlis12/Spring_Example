package com.example.lesson04.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson04.dao.UserDAO;

@Service
public class UserBO {
	
	@Autowired
	private UserDAO userDAO;
	
	// 회원가입
	public int addUser(String name, String yyyymmdd, String introduce, String email) {
		
		return userDAO.insertUser(name, yyyymmdd, introduce, email);
	}
}
