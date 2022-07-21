package com.pinwormmy.mall.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pinwormmy.mall.dto.CartDTO;
import com.pinwormmy.mall.dto.OrderInfoDTO;
import com.pinwormmy.mall.dto.ProductDTO;
import com.pinwormmy.mall.service.OrderService;

@Controller
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@RequestMapping(value = "/showCart", method = RequestMethod.GET)
	public String showCart(Model model, String userId) throws Exception {
		List<CartDTO> showCart = orderService.showCart(userId);		
		model.addAttribute("cartList", showCart);

		return "cart";
	}
	
	@RequestMapping(value = "/addCart", method = RequestMethod.GET)
	public String addCart(Model model, CartDTO cart) throws Exception {				
		orderService.addCart(cart);
		
		return "redirect:/showCart?userId=" + cart.getUserId();
	}
	
	@RequestMapping(value = "/deleteCart", method = RequestMethod.GET)
	public String deleteCart(CartDTO cart) throws Exception {
		orderService.deleteCart(cart.getCartNum());
		
		return "redirect:/showCart?userId=" + cart.getUserId();
	}
	
	@RequestMapping(value = "/purchasePage", method = RequestMethod.GET)
	public String purchasePage(Model model, String userId) throws Exception {
		List<CartDTO> showCart = orderService.showCart(userId);		
		model.addAttribute("cartList", showCart);

		return "purchasePage";
	}
	
	@RequestMapping(value = "/order", method = RequestMethod.POST)
	public String order(Model model, OrderInfoDTO orderInfo) throws Exception {
				
		orderService.order(orderInfo);
		
		// 아직 페이지 안만들어서 그냥 메인으로
		return "redirect:/";
	}
}
