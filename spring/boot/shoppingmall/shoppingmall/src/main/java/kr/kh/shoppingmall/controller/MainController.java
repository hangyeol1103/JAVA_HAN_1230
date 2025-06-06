package kr.kh.shoppingmall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.kh.shoppingmall.model.vo.CategoryVO;
import kr.kh.shoppingmall.model.vo.MemberVO;
import kr.kh.shoppingmall.service.MemberService;
import kr.kh.shoppingmall.service.ProductService;

import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class MainController {
	
	@Autowired
	MemberService memberService;
	@Autowired
	ProductService productService;

	@GetMapping("/")
	public String main() {
		return "index";
	}

	@GetMapping("/signup")
	public String signup() {
		return "user/signup";
	}
	
	@PostMapping("/signup")
	public String singupPost(MemberVO member) {
		if(memberService.signup(member)){
			return "redirect:/";
		}
		return "redirect:/signup";
	}
	
	@GetMapping("/check/id")
	@ResponseBody
	public boolean checkId(@RequestParam String id){
		return memberService.checkId(id);
	}
	
	@GetMapping("/login")
	public String login() {
		
		return "user/login";
	}
	
	@GetMapping("/category/{ca_num}")
	public String category(Model model, @PathVariable int ca_num) {
		List<CategoryVO> list = productService.getCategory();
		model.addAttribute("list", list);
		return "layout/header";
	}
	
}
