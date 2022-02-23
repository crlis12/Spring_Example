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
	
	public int AddReview(Review review) {
		return reviewDAO.insertReview(review);
	}
	
	public int addReviewAsField(int storeId, String menu, 
			String userName, double point, String review) {
		return reviewDAO.insertReviewAsField(storeId, menu, userName, point, review);
	}
	
	public int updateReviewById(int id, String review) {
		
		return reviewDAO.updateReviewById(id, review);
	}
	
	
}
