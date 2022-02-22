package com.example.lesson03;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson03.bo.ReviewBo;
import com.example.lesson03.model.Review;

@RestController
public class Lesson03Ex01RestController {

	// 요청 URL: http://localhost:8080/lesson03/ex01
	// 요청 URL: http://localhost:8080/lesson03/ex01?id=2
	@Autowired
	private ReviewBo reviewBO;

	@RequestMapping("/lesson03/ex01")
	public Review ex01(
			// @RequestParam(value="id") int id // parameter 사용자가 원하는 id값을 가지고 온다 필수 파라미터
			// @RequestParam(value="id", required = true) int id // 필수 파라미터
			// @RequestParam(value="id", required = false) int id // 비필수 파라미터
			@RequestParam(value = "id", required = false, defaultValue = "1") int id) { // 비필수 파라미터, 값이 안넘어왔을때 default값으로 기본값을 채워준다
		System.out.println("########## id:" + id);
		return reviewBO.getReview(id);
	}
}
