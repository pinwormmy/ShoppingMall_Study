package com.pinwormmy.mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public String modifyProduct(ProductDTO productDTO, Model model) throws Exception {
		
		productDTO = productService.productDetails(productDTO);
		model.addAttribute("product", productDTO);
				
		return "modifyProduct";
	}
	
	@RequestMapping(value = "/submitModifyProduct", method = RequestMethod.POST)
	public String submitModifyProduct(ProductDTO productDTO) throws Exception {
		
		productService.submitModifyProduct(productDTO);
		
		return "redirect:/productDetails?productNum=" + productDTO.getProductNum();
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
	
	@RequestMapping(value = "/productDetails", method = RequestMethod.GET)
	public String productDetails(ProductDTO productDTO, Model model) throws Exception {
		
		productDTO = productService.productDetails(productDTO);
		model.addAttribute("product", productDTO);
		
		return "productDetails";
	}
	
}

