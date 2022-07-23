package com.pinwormmy.mall.order;

import java.util.Date;

import lombok.Data;

@Data
public class OrderInfoDTO {

	private int orderNum;
	private String userId;
	private String address;
	private String paymentType;
	private int price;
	private Date regDate;
	private String creditNum;
	private String status;
}
