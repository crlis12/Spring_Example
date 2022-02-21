package com.example.lesson03.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson03.dao.ReviewDAO;
import com.example.lesson03.model.Review;

@Service
public class ReviewBo {
	
	@Autowired
	private ReviewDAO reviewDAO;
	
	public Review getReview(Integer id) {	//By~    ~를 가지고 온다
		
		return reviewDAO.selectReview(id);
	}
}
