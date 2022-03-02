package com.pinwormmy.mall.service;

import java.util.List;

import com.pinwormmy.mall.dto.ProductDTO;

public interface ProductService {

	public void submitProduct(ProductDTO productDTO);
	
	public List<ProductDTO> productList(ProductDTO productDTO);

}
