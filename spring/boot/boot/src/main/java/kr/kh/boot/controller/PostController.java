package kr.kh.boot.controller;
 
 import java.util.List;
 
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.security.core.annotation.AuthenticationPrincipal;
 import org.springframework.stereotype.Controller;
 import org.springframework.ui.Model;
 import org.springframework.web.bind.annotation.GetMapping;
 import org.springframework.web.bind.annotation.PathVariable;
 import org.springframework.web.bind.annotation.PostMapping;
 
 import kr.kh.boot.model.vo.BoardVO;
 import kr.kh.boot.model.vo.CustomUser;
 import kr.kh.boot.model.vo.FileVO;
 import kr.kh.boot.model.vo.MemberVO;
 import kr.kh.boot.model.vo.PostVO;
 import kr.kh.boot.service.PostService;
 import org.springframework.web.bind.annotation.RequestParam;
 
 
 
 @Controller
 public class PostController {
 
 	@Autowired
 	PostService postService;
 
 	@GetMapping("/post/list/{bo_num}")
 	public String postList(Model model, @PathVariable int bo_num) {
 		//등록된 전체 게시판을 가져옴
 		List<BoardVO> boardList = postService.getBoardList();
 
 		//게시판 번호에 맞는 게시글 목록을 가져옴
 		List<PostVO> list = postService.getPostList(bo_num);
 		model.addAttribute("list", list);
 		model.addAttribute("url", "/post/list");
 		model.addAttribute("boardList", boardList);
 		return "post/list";
 	}
 
 	@GetMapping("/post/detail/{po_num}")
 	public String getMethodName(Model model, @PathVariable int po_num) {
 		PostVO post = postService.getPost(po_num);
 		List<FileVO> list = postService.getFileList(po_num);
 		model.addAttribute("post", post);
 		model.addAttribute("list", list);
 		return "post/detail";
 	}
 
 	@GetMapping("/post/insert")
 	public String postInsert(Model model) {
 		List<BoardVO> list = postService.getBoardList();
 		model.addAttribute("list", list);
 		return "post/insert";
 	}
 	@PostMapping("/post/insert")
 	public String postInsertPost(PostVO post, @AuthenticationPrincipal CustomUser customUser) {
 		//로그인한 회원 정보를 가져옴
 		if(customUser != null){
 			MemberVO user = customUser.getMember();
 			post.setPo_me_id(user.getMe_id());
 		}
 		if(postService.insertPost(post)){
 			return "redirect:/post/list/" + post.getPo_bo_num();
 		}
 		return "redirect:/post/insert";
 	}
 }