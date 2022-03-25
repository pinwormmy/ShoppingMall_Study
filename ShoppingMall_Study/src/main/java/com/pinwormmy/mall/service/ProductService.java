package com.pinwormmy.mall.service;

import java.util.List;

import com.pinwormmy.mall.dto.ProductDTO;

public interface ProductService {

	public void submitProduct(ProductDTO productDTO) throws Exception;
	
	public List<ProductDTO> productList() throws Exception;

	public void deleteProduct(ProductDTO productDTO) throws Exception;

	public ProductDTO productDetails(ProductDTO productDTO) throws Exception;

	public void submitModifyProduct(ProductDTO productDTO) throws Exception;

	public void sendThumbnailPath(ProductDTO productDTO) throws Exception;

}
