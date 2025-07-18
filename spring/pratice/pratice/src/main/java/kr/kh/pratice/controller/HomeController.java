package kr.kh.pratice.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HomeController {
	
	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("name", "홍길동");
		return "index";
	}
	
	@GetMapping("/test")
	public String test(Model model) {
		int num = (int)(Math.random()*10);
		String role = "";
		switch (num) {
			case 4,6,8:
				role = "ADMIN";
				break;
			case 3,5,7,9:
				role = "USER";
				break;
		}
		
		List<Integer> list = Arrays.asList(10,20,30,40);
		model.addAttribute("num", num);
		model.addAttribute("role", role);
		model.addAttribute("items", list);
		return "test";
	}

	@GetMapping("/test/{num}")
	public String testNum(@PathVariable int num) { //보통은 {num}과 pathvariable의 num을 맞춰 쓰면 생략이 가능하지만 {num}을 {num1}로 바꿔쓴다면 @PathVariable("num1") 붙여줘야 함.
		System.out.println(num);
		return "test";
	}
	
	
}
