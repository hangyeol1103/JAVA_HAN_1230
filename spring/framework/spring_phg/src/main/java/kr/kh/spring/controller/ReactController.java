package kr.kh.spring.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.kh.spring.model.vo.BoardVO;
import kr.kh.spring.model.vo.PostVO;
import kr.kh.spring.paginagion.PageMaker;
import kr.kh.spring.paginagion.PostCriteria;
import kr.kh.spring.service.PostService;

@RestController
public class ReactController {

	@Autowired
	private PostService postService;
	
	@GetMapping("/react/post/list")
	public Map<String,Object> postList(PostCriteria cri) {
		cri.setPerPageNum(2);
		List<PostVO> list = postService.getPostList(cri);
		List<BoardVO> boardlist = postService.getBoardList();	
		PageMaker pm = postService.getPageMaker(cri);

		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("pm", pm);
		map.put("boardlist", boardlist);
		return map;
	}
	@GetMapping("/test")
	public String test() {
		return "Hello";
	}
}
