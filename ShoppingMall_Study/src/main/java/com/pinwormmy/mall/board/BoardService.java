package com.pinwormmy.mall.board;

import java.util.List;

import com.pinwormmy.mall.util.PageDTO;

public interface BoardService {

	public void submitPost(FreeBoardDTO freeBoardDTO) throws Exception;

	public List<FreeBoardDTO> showPostList() throws Exception;

	public FreeBoardDTO readPost(int postNum) throws Exception;

	public void submitModifyPost(FreeBoardDTO freeBoardDTO) throws Exception;

	public void deletePost(int postNum) throws Exception;

	public int countTotalPost() throws Exception;
	
	public PageDTO pageSetting() throws Exception;
	
	public PageDTO pageSetting(int recentPage) throws Exception;
}
