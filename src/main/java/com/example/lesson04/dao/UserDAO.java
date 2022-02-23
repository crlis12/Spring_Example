package com.example.lesson04.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO {
	
	// 회원가입
	 public int insertUser(
			 String name,
			 String yyyymmdd,
			 String introduce,
			 String email);
	 
}
