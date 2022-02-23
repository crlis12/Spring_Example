package com.example.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson03.bo.ReviewBo;

@RestController
public class Lesson03Ex03RestController {
	
	//요청 url: http://localhost:8080/lesson03/ex03?id=21&review=족발은 역시 맛있어
	
	@Autowired
	private ReviewBo reviewBo;
	
	@RequestMapping("/lesson03/ex03")
	public String ex03(
			@RequestParam(value = "id") int id,
			@RequestParam(value = "review") String review) {
		
		int row = reviewBo.updateReviewById(id, review);
		
		return "변경완료: " + row;
	}
	
}
