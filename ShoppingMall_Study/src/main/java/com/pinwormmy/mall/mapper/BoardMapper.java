package com.pinwormmy.mall.mapper;

import java.util.List;

import com.pinwormmy.mall.board.FreeBoardDTO;

public interface BoardMapper {
	
	public void submitPost(FreeBoardDTO freeBoardDTO) throws Exception;

	public List<FreeBoardDTO> showPostList() throws Exception;

	public FreeBoardDTO readPost(int postNum) throws Exception;

	public void submitModifyPost(FreeBoardDTO freeBoardDTO) throws Exception;

	public void deletePost(int postNum) throws Exception;

	public int countTotalPost() throws Exception;
}
