package com.pinwormmy.mall.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pinwormmy.mall.mapper.BoardMapper;

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
		int recentPage = 1;	
		return calculatePage(recentPage);
	}
	@Override
	public PageDTO pageSetting(int recentPage) throws Exception {		
		return calculatePage(recentPage);
	}
	
	private PageDTO calculatePage(int recentPage) throws Exception {
		
		PageDTO page = new PageDTO();		
		
		final int DISPLAY_POST_LIMIT = 10;
		final int PAGESET_LIMIT = 10;
		
		int postEndPoint = recentPage * DISPLAY_POST_LIMIT - 1;
		int postBeginPoint = postEndPoint - (DISPLAY_POST_LIMIT - 1);			
		
		int totalPostCount = countTotalPost();
		int totalPage = (int)Math.ceil((double)totalPostCount/DISPLAY_POST_LIMIT);
		int pageBeginPoint = (recentPage-1) / PAGESET_LIMIT * PAGESET_LIMIT + 1;	
		int pageEndPoint = pageBeginPoint + PAGESET_LIMIT - 1;	
		if(pageEndPoint > totalPage)
			pageEndPoint = totalPage;
		
		int prevPageSetPoint = pageEndPoint - PAGESET_LIMIT;
		int nextPageSetPoint = pageBeginPoint + PAGESET_LIMIT;	
		
		page.setPageBeginPoint(pageBeginPoint);
		page.setPostEndPoint(postEndPoint);
		page.setPostBeginPoint(postBeginPoint);
		page.setPageEndPoint(pageEndPoint);
		page.setPrevPageSetPoint(prevPageSetPoint);
		page.setNextPageSetPoint(nextPageSetPoint);
		page.setTotalPage(totalPage);
		
		return page;
	}
}
