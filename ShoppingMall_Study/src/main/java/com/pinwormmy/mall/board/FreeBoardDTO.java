package com.pinwormmy.mall.board;

import java.util.Date;

import lombok.Data;

@Data
public class FreeBoardDTO {
	private int postNum;
	private String title;
	private String writer;
	private String content;
	private Date regDate;
	private int views;
}
