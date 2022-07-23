package com.pinwormmy.mall.order;

import com.pinwormmy.mall.product.ProductDTO;

import lombok.Data;

@Data
public class CartDTO {
	
	private int cartNum;
	private int productNum;
	private String userId;
	private int quantity;
	
	private ProductDTO productDTO;
}
