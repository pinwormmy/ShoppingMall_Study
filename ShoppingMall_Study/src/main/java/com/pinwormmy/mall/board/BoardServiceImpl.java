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
	
}
