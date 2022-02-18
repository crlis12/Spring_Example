package com.example.lesson01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Lesson01Ex02Controller {
	//요청 URL: http://localhost:8080/lesson01/ex02/1
	@RequestMapping("/lesson01/ex02/1")
	public String ex02_1() {
		//ResponseBody가 아닌 상태롤 String 을 리턴하면
		//ViewResolver에 의해서 리턴된 String 이름의 view를 찾고 view화면이 구성된다.
		
		// /WEB-INF/jsp/lesson01/ex02.jsp
		//application.properties에 경로를 적어놓지 않으면 위에 주소로 다 적어야 한다
		return "lesson01/ex02"; // jsp view 경로와 이름
	}
}
