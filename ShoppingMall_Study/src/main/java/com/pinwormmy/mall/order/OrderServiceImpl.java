package com.pinwormmy.mall.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pinwormmy.mall.mapper.OrderMapper;
import com.pinwormmy.mall.util.PageDTO;
import com.pinwormmy.mall.util.PageService;

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
	
	@Override
	public int countTotalProductInCart(String userId) throws Exception {
		return orderMapper.countTotalProductInCart(userId);
	}
	
	@Override
	public PageDTO pageSetting(String userId) throws Exception {		
		int recentPage = 1;	// 첫페이지		
		return utilLoadingForPage(recentPage, userId);
	}
	
	@Override
	public PageDTO pageSetting(int recentPage, String userId) throws Exception {			
		return utilLoadingForPage(recentPage, userId);
	}	
	
	private PageDTO utilLoadingForPage(int recentPage, String userId) throws Exception {
		int totalPostCount = countTotalProductInCart(userId);		
		PageService util = initPageUtil();
		return util.calculatePage(recentPage, totalPostCount);
	}
	
	private PageService initPageUtil() {
		PageService util = new PageService();
		util.setDISPLAY_POST_LIMIT(7);
		util.setPAGESET_LIMIT(5);
		return util;
	}
}
