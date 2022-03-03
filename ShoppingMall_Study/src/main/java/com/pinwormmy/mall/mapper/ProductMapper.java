package com.pinwormmy.mall.mapper;

import java.util.List;

import com.pinwormmy.mall.dto.ProductDTO;

public interface ProductMapper {

	public void submitProduct(ProductDTO productDTO) throws Exception;
	
	public List<ProductDTO> productList() throws Exception;

	public void deleteProduct(ProductDTO productDTO) throws Exception;

}
