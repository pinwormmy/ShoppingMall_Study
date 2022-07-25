package com.pinwormmy.mall.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
		
	@RequestMapping(value = "/freeBoard", method = RequestMethod.GET)
	public String goFreeboard(Model model) throws Exception {
		
		List<FreeBoardDTO> postList = boardService.showPostList();		
		model.addAttribute("postList", postList);
		
		return "freeBoard";
	}
	
	@RequestMapping(value = "/writePost", method = RequestMethod.GET)
	public String writePost() throws Exception {
		
		return "writePost";
	}
	
	@RequestMapping(value = "/submitPost", method = RequestMethod.POST)
	public String submitPost(FreeBoardDTO freeBoardDTO) throws Exception {
		
		boardService.submitPost(freeBoardDTO);
		
		return "redirect:/freeBoard";
	}
	
	@RequestMapping(value = "/readPost", method = RequestMethod.GET)
	public String readPost(Model model, int postNum) throws Exception {		
		FreeBoardDTO post = boardService.readPost(postNum);
		model.addAttribute("post", post);
		return "readPost";
	}
	
}

