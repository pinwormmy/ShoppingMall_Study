package com.pinwormmy.mall.mapper;

import java.util.List;

import com.pinwormmy.mall.dto.ProductDTO;

public interface ProductMapper {

	public void submitProduct(ProductDTO productDTO);
	
	public List<ProductDTO> productList(ProductDTO productDTO);

}
