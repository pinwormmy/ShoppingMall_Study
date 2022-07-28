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
		
		int recentPage = 1; 
		int totalPostCount = boardService.countTotalPost();		
		int displayPostLimit = 10;
		int pageSetLimit = 10;
		int pageBeginPoint = (recentPage-1) / pageSetLimit * pageSetLimit + 1;		
		int postEndPoint = recentPage * displayPostLimit - 1;
		int postBeginPoint = postEndPoint - (displayPostLimit - 1);				
		int totalPage = (int)Math.ceil((double)totalPostCount/displayPostLimit);
		int pageEndPoint = pageBeginPoint + pageSetLimit - 1;	
		if(pageEndPoint > totalPage)
			pageEndPoint = totalPage;
		int prevPageSetPoint = pageEndPoint - pageSetLimit;
		int nextPageSetPoint = pageBeginPoint + pageSetLimit;		
		
		System.out.println("다음 페이지셋 ? " + nextPageSetPoint);
		
		model.addAttribute("recentPage", recentPage);		
		model.addAttribute("postBeginPoint", postBeginPoint);
		model.addAttribute("postEndPoint", postEndPoint);	
		model.addAttribute("pageBeginPoint", pageBeginPoint);
		model.addAttribute("pageEndPoint", pageEndPoint);
		model.addAttribute("prevPageSetPoint", prevPageSetPoint);
		model.addAttribute("nextPageSetPoint", nextPageSetPoint);		
		model.addAttribute("totalPage", totalPage);
		
		return "freeBoard";
	}
	
	@RequestMapping(value = "/freeBoardPage", method = RequestMethod.GET)
	public String freeBoardPage(Model model, int recentPage) throws Exception {	
		
		List<FreeBoardDTO> postList = boardService.showPostList();		
		model.addAttribute("postList", postList);	
		
		int totalPostCount = boardService.countTotalPost();		
		int displayPostLimit = 10;
		int pageSetLimit = 10;
		int pageBeginPoint = (recentPage-1) / pageSetLimit * pageSetLimit + 1;		
		int postEndPoint = recentPage * displayPostLimit - 1;
		int postBeginPoint = postEndPoint - (displayPostLimit - 1);				
		int totalPage = (int)Math.ceil((double)totalPostCount/displayPostLimit);
		int pageEndPoint = pageBeginPoint + pageSetLimit - 1;	
		if(pageEndPoint > totalPage)
			pageEndPoint = totalPage;
		int prevPageSetPoint = pageEndPoint - pageSetLimit;
		int nextPageSetPoint = pageBeginPoint + pageSetLimit;		
		
		System.out.println("다음 페이지셋 ? " + nextPageSetPoint);
		
		model.addAttribute("recentPage", recentPage);		
		model.addAttribute("postBeginPoint", postBeginPoint);
		model.addAttribute("postEndPoint", postEndPoint);	
		model.addAttribute("pageBeginPoint", pageBeginPoint);
		model.addAttribute("pageEndPoint", pageEndPoint);
		model.addAttribute("prevPageSetPoint", prevPageSetPoint);
		model.addAttribute("nextPageSetPoint", nextPageSetPoint);		
		model.addAttribute("totalPage", totalPage);
		
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
	
	@RequestMapping(value = "/modifyPost", method = RequestMethod.GET)
	public String modifyPost(Model model, int postNum) throws Exception {	
		FreeBoardDTO post = boardService.readPost(postNum);
		model.addAttribute("post", post);
		return "modifyPost";
	}
	
	@RequestMapping(value = "/submitModifyPost", method = RequestMethod.POST)
	public String submitModifyPost(FreeBoardDTO freeBoardDTO) throws Exception {		
		boardService.submitModifyPost(freeBoardDTO);		
		return "redirect:/readPost?postNum=" + freeBoardDTO.getPostNum();
	}
	
	@RequestMapping(value = "/deletePost", method = RequestMethod.GET)
	public String deletePost(int postNum) throws Exception {		
		boardService.deletePost(postNum);		
		return "redirect:/freeBoard";
	}
}

