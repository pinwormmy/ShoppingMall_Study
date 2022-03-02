package com.pinwormmy.mall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pinwormmy.mall.dto.ProductDTO;
import com.pinwormmy.mall.service.ProductService;

@Controller
public class HomeController {
	
	@Autowired
	private ProductService productService;
		
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		
		List<ProductDTO> productList = productService.productList;
		
		return "home";
	}
	
}

