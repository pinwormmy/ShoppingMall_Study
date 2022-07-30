package com.pinwormmy.mall.order;

import java.util.List;

import com.pinwormmy.mall.util.PageDTO;

public interface OrderService {

	public List<CartDTO> showCart(String userId) throws Exception;

	public void addCart(CartDTO cart) throws Exception;

	public void deleteCart(int cartNum) throws Exception;

	public void order(OrderInfoDTO orderInfo) throws Exception;

	public List<OrderInfoDTO> showOrderList(String userId) throws Exception;

	public void resetCart(String userId) throws Exception;
	
	int countTotalProductInCart(String userId) throws Exception;
	
	public PageDTO pageSetting(String userId) throws Exception;
	
	public PageDTO pageSetting(int recentPage, String userId) throws Exception;
	
}
