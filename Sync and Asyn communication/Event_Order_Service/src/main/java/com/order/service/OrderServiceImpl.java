package com.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.client.OrderClient;
import com.order.dto.ProductDto;
import com.order.entity.OrderEntity;
import com.order.repositoty.OrderRepositoty;
import com.order.request.OrderRequest;

@Service
public class OrderServiceImpl implements OrderService
{
	@Autowired
	OrderRepositoty repositoty;

	@Autowired
	OrderClient client;

	@Override
	public ProductDto createNewOrder(OrderRequest request)
	{
		ProductDto dto = client.findById(request.getProductId());

		OrderEntity entity = new OrderEntity();
		entity.setProductId(request.getProductId());
		entity.setQty(request.getQty());

		repositoty.save(entity);
		return dto;
	}

}
