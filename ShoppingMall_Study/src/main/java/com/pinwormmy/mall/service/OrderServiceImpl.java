package com.pinwormmy.mall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pinwormmy.mall.dto.CartDTO;
import com.pinwormmy.mall.mapper.OrderMapper;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	OrderMapper orderMapper;

	@Override
	public List<CartDTO> showCart(String userId) throws Exception {				
		
		return orderMapper.showCart(userId);
	}

	@Override
	public void addCart(CartDTO cart) throws Exception {
		orderMapper.addCart(cart);
	}

}
