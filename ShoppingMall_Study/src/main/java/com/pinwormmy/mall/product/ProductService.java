package com.pinwormmy.mall.product;

import java.util.List;

public interface ProductService {

	public void submitProduct(ProductDTO productDTO) throws Exception;
	
	public List<ProductDTO> productList() throws Exception;

	public void deleteProduct(ProductDTO productDTO) throws Exception;

	public ProductDTO productDetails(ProductDTO productDTO) throws Exception;

	public void submitModifyProduct(ProductDTO productDTO) throws Exception;

	public void sendThumbnailPath(ProductDTO productDTO) throws Exception;

}
