package com.pinwormmy.mall.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pinwormmy.mall.dto.CartDTO;
import com.pinwormmy.mall.dto.OrderInfoDTO;
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
	
	@RequestMapping(value = "/orderProduct", method = RequestMethod.POST)
	public String orderProduct(OrderInfoDTO orderInfo) throws Exception {
				
		orderService.order(orderInfo);	
		orderService.resetCart(orderInfo.getUserId());
		
		// 일단 메인화면으로 보내기
		return "redirect:/";
	}
	
	@RequestMapping(value = "/showOrderList", method = RequestMethod.GET)
	public String orderList(Model model, String userId) throws Exception {
				
		List<OrderInfoDTO> orderList = orderService.showOrderList(userId);		
		model.addAttribute("orderList", orderList);
		
		return "orderList";
	}
}
