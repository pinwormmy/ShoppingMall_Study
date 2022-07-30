package com.pinwormmy.mall.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pinwormmy.mall.mapper.BoardMapper;
import com.pinwormmy.mall.util.PageDTO;
import com.pinwormmy.mall.util.PageService;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardMapper boardMapper;
	
	@Override
	public void submitPost(FreeBoardDTO freeBoardDTO) throws Exception {
		boardMapper.submitPost(freeBoardDTO);
	}

	@Override
	public List<FreeBoardDTO> showPostList() throws Exception {		
		return boardMapper.showPostList();
	}

	@Override
	public FreeBoardDTO readPost(int postNum) throws Exception {
		return boardMapper.readPost(postNum);
	}

	@Override
	public void submitModifyPost(FreeBoardDTO freeBoardDTO) throws Exception {
		boardMapper.submitModifyPost(freeBoardDTO);		
	}

	@Override
	public void deletePost(int postNum) throws Exception {
		boardMapper.deletePost(postNum);		
	}

	@Override
	public int countTotalPost() throws Exception {
		return boardMapper.countTotalPost();
	}
	
	@Override
	public PageDTO pageSetting() throws Exception {		
		int recentPage = 1;	// 첫페이지		
		return utilLoadingForPage(recentPage);
	}
	
	@Override
	public PageDTO pageSetting(int recentPage) throws Exception {			
		return utilLoadingForPage(recentPage);
	}	
	
	private PageDTO utilLoadingForPage(int recentPage) throws Exception {
		int totalPostCount = countTotalPost();		
		PageService util = initPageUtil();
		return util.calculatePage(recentPage, totalPostCount);
	}
	
	private PageService initPageUtil() {
		PageService util = new PageService();
		util.setDISPLAY_POST_LIMIT(15);
		util.setPAGESET_LIMIT(15);
		return util;
	}
}
