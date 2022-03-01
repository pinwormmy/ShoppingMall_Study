package com.pinwormmy.mall.service;

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

}
