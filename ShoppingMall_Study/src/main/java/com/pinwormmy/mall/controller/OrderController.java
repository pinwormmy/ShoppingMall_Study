package com.pinwormmy.mall.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.pinwormmy.mall.service.OrderService;

@Controller
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	
}
