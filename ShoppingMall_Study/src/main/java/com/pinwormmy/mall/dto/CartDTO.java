package com.pinwormmy.mall.dto;

import lombok.Data;

@Data
public class CartDTO {
	
	private int cartNum;
	private int productNum;
	private String userId;
	private int quantity;
	
	private ProductDTO produtDTO;
}
