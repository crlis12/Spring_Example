package com.example.lesson05;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Lesson05Controller {

	
	@RequestMapping("/lesson05/ex01")
	public String ex01() {
		return "lesson05/ex01";
	}
	
	@RequestMapping("/lesson05/ex02")
	public String ex02(Model model) {
		// String 리스트
		List<String> fruits = new ArrayList<>();
		fruits.add("사과");
		fruits.add("멜론");
		fruits.add("포토");
		fruits.add("딸기");
		fruits.add("망고");
		
		model.addAttribute("fruits", fruits);
		
		//List<Map>
		List<Map<String, Object>> users = new ArrayList<>();
		
		Map<String, Object> userMap = new HashMap<String, Object>();
		userMap.put("name", "이창렬");
		userMap.put("age", 25);
		userMap.put("hobby", "여행");
		users.add(userMap);
		
		userMap = new HashMap<String, Object>();
		userMap.put("name", "바다");
		userMap.put("age", 20);
		userMap.put("hobby", "물놀이");
		users.add(userMap);
		
		model.addAttribute("users", users);
		
		return "lesson05/ex02";
	}
	
	@RequestMapping("/lesson05/ex03")
	public String ex03(Model model) {
		Date today = new Date();
		model.addAttribute("today",today);
		
		return "lesson05/ex03";
	}
	
	@RequestMapping("/lesson05/ex04")
	public String ex04() {
		return "lesson05/ex04";
	}
	
}
