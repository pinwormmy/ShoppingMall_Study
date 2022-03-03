package com.pinwormmy.mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pinwormmy.mall.dto.ProductDTO;
import com.pinwormmy.mall.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;
		
	@RequestMapping(value = "/addProduct", method = RequestMethod.GET)
	public String addProduct() {
		
		return "addProduct";
	}
	
	@RequestMapping(value = "/modifyProduct", method = RequestMethod.GET)
	public String modifyProduct() {
		
		return "modifyProduct";
	}
	
	@RequestMapping(value = "/deleteProduct", method = RequestMethod.GET)
	public String deleteProduct(ProductDTO productDTO) throws Exception {
		
		productService.deleteProduct(productDTO);
		
		return "redirect:/";
	}
	
	@RequestMapping(value = "/submitProduct", method = RequestMethod.GET)
	public String submitProduct(ProductDTO productDTO) throws Exception {
		
		productService.submitProduct(productDTO);
		
		return "redirect:/";
	}
	
}

