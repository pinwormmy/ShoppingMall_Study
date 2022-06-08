package com.pinwormmy.mall.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;


@Data
public class ProductDTO {
	
	private int productNum;
	private String productName;
	private int productPrice;
	private String productDescription;
	@DateTimeFormat(pattern ="yyyy/MM/dd hh:mm:ss a")
	private Date regDate;
	private String thumbnailPath;
	

}
