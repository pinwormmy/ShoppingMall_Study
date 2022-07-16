package com.pinwormmy.mall.mapper;

import java.util.List;

import com.pinwormmy.mall.dto.CartDTO;

public interface OrderMapper {

	public List<CartDTO> showCart(String userId) throws Exception;

	public void addCart(CartDTO cart) throws Exception;

	public void deleteCart(int cartNum) throws Exception;
	
}
