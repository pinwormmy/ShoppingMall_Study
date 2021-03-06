package com.pinwormmy.mall.mapper;

import java.util.List;

import com.pinwormmy.mall.order.CartDTO;
import com.pinwormmy.mall.order.OrderInfoDTO;

public interface OrderMapper {

	public List<CartDTO> showCart(String userId) throws Exception;

	public void addCart(CartDTO cart) throws Exception;

	public void deleteCart(int cartNum) throws Exception;

	public void order(OrderInfoDTO orderInfo) throws Exception;

	public List<OrderInfoDTO> showOrderList(String userId) throws Exception;

	public void resetCart(String userId) throws Exception;

	public int countTotalProductInCart(String userId) throws Exception;
}
