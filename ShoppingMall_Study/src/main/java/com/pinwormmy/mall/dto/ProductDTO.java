package com.pinwormmy.mall.dto;

import lombok.Data;
import oracle.sql.DATE;

@Data
public class ProductDTO {
	
	private int productNum;
	private String productName;
	private int productPrice;
	private String productDescription;
	private DATE regDate;
	private String thumbnailPath;
	

}
