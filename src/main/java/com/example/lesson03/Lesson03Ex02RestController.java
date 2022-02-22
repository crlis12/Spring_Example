package com.example.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson03.bo.ReviewBo;
import com.example.lesson03.model.Review;

@RestController
public class Lesson03Ex02RestController {

	@Autowired
	private ReviewBo reviewBo;

	// 요청 URL : http://localhost:8080/lesson03/ex02/1
	@RequestMapping("/lesson03/ex02/1")
	public String ex02() {
		Review review = new Review();
		review.setStoreId(7);
		review.setMenu("삼겹혼밥세트");
		review.setUserName("신보람");
		review.setPoint(4.5);
		review.setReview("혼자 먹기 딱 적당하네요.");

		int rowCount = reviewBo.AddReview(review); // insert된 행의 수를 리턴 받는다
		return "success row count : " + rowCount;
	}

	// 요청 URL : http://localhost:8080/lesson03/ex02/2
	@RequestMapping("/lesson03/ex02/2")
	public String ex02_2() {
		int row = reviewBo.addReviewAsField(11, "콤비네이션R", "이창렬", 5.0, "역시 맛있다!!!"); // AsField 따로따로 붙여서 만든테이블 이름
		return "입력 성공 : " + row;
	}
}
