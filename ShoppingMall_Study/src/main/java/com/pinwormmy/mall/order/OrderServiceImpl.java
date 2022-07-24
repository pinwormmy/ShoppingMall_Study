package com.pinwormmy.mall.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	@Override
	public void deleteCart(int cartNum) throws Exception {
		orderMapper.deleteCart(cartNum);		
	}

	@Override
	public void order(OrderInfoDTO orderInfo) throws Exception {
		orderMapper.order(orderInfo);
		
	}

	@Override
	public List<OrderInfoDTO> showOrderList(String userId) throws Exception {
		return orderMapper.showOrderList(userId);
	}

	@Override
	public void resetCart(String userId) throws Exception {
		orderMapper.resetCart(userId);	
	}
}