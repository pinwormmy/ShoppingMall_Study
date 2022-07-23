package com.pinwormmy.mall.mapper;

import java.util.List;

import com.pinwormmy.mall.product.ProductDTO;

public interface ProductMapper {

	public void submitProduct(ProductDTO productDTO) throws Exception;
	
	public List<ProductDTO> productList() throws Exception;

	public void deleteProduct(ProductDTO productDTO) throws Exception;

	public ProductDTO productDetails(ProductDTO productDTO) throws Exception;

	public void submitModifyProduct(ProductDTO productDTO) throws Exception;

	public void sendThumbnailPath(ProductDTO productDTO) throws Exception;

}
