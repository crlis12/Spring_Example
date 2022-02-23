package com.example.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.lesson04.bo.UserBO;

@Controller
public class Lesson04Ex01Controller {
	
	// 회원 가입 화면
	// 요청: http://localhost:8080/lesson04/ex01/1
	@RequestMapping(path="/lesson04/ex01/1", method=RequestMethod.GET )  // get방식으로 밖에 못들어온다
	public String ex01() {
		
		// /WEB-INF/jsp/  .jsp
		// /WEB-INF/jsp/lesson04/add_user.jsp
		return "lesson04/add_user";  // view 경로
	}
	
	// 405 에러 : Request method 불일치 //post방식을 주소로 들어갈 수 없다.
	// 요청 http://localhost:8080/lesson04/ex01/add_user
	@Autowired
	private UserBO userBO;
	
	@PostMapping("/lesson04/ex01/add_user")	//post방식만 허용한다는 맵핑
	public String addUser(
			@RequestParam("name") String name,
			@RequestParam("yyyymmdd") String yyyymmdd,
			@RequestParam("email") String email,
			@RequestParam(value = "introduce", required = false) String introduce) {  // null값이 허용된다 
		
		//insert DB
		int row = userBO.addUser(name, yyyymmdd, introduce, email);
		
		
		// 결과 jsp
		return "lesson04/after_add_user"; 	//결과 경로
	}
}
