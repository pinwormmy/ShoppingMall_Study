package com.pinwormmy.mall.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.pinwormmy.mall.service.OrderService;
import com.pinwormmy.mall.service.ProductService;

@Controller
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	
}
