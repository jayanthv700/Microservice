package com.feignorder.service;

import java.util.List;

import com.feignorder.dto.OrderRequest;
import com.feignorder.model.OrderEntity;

public interface OrderService
{
	public OrderEntity createOrder(OrderRequest request);

	public OrderEntity findOrderById(Long id);

	public List<OrderEntity> findAll();
}
