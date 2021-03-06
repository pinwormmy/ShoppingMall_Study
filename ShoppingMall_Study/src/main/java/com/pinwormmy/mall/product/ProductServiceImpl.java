
package com.pinwormmy.mall.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pinwormmy.mall.mapper.ProductMapper;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductMapper productMapper;

	@Override
	public void submitProduct(ProductDTO productDTO) throws Exception{
				
		productMapper.submitProduct(productDTO);
	}

	@Override
	public List<ProductDTO> productList() throws Exception{
		
		return productMapper.productList();
	}

	@Override
	public void deleteProduct(ProductDTO productDTO) throws Exception{
		
		productMapper.deleteProduct(productDTO);
		
	}

	@Override
	public ProductDTO productDetails(ProductDTO productDTO) throws Exception {
		
		return productMapper.productDetails(productDTO);
	}

	@Override
	public void submitModifyProduct(ProductDTO productDTO) throws Exception {
		
		productMapper.submitModifyProduct(productDTO);
	}

	@Override
	public void sendThumbnailPath(ProductDTO productDTO) throws Exception {

		productMapper.sendThumbnailPath(productDTO);
		
	}

}
