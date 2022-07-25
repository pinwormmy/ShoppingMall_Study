package com.pinwormmy.mall.board;

import java.util.List;

public interface BoardService {

	public void submitPost(FreeBoardDTO freeBoardDTO) throws Exception;

	public List<FreeBoardDTO> showPostList() throws Exception;

	public FreeBoardDTO readPost(int postNum) throws Exception;

}
