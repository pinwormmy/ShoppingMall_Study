package com.pinwormmy.mall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pinwormmy.mall.dto.ProductDTO;
import com.pinwormmy.mall.mapper.ProductMapper;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductMapper productMapper;

	@Override
	public void submitProduct(ProductDTO productDTO) {
		
		productMapper.submitProduct(productDTO);
	}

	@Override
	public List<ProductDTO> productList(ProductDTO productDTO) {
		
		return productMapper.productList(productDTO);
	}

}
