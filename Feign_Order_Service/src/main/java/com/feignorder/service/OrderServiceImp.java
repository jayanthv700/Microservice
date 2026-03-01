package com.feignorder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feignorder.dto.OrderRequest;
import com.feignorder.model.OrderEntity;
import com.feignorder.repository.OrderRepository;

@Service
public class OrderServiceImp implements OrderService
{
	@Autowired
	OrderRepository repository;

	@Override
	public OrderEntity createOrder(OrderRequest request)
	{
		// Data building using getter and setter
//		OrderEntity entity = new OrderEntity();
//		entity.setPrice(request.getPrice());
//		entity.setProduceName(request.getProduceName());

		// data building using constructor
//		OrderEntity entity = new OrderEntity(null, request.getProduceName(), request.getPrice());

		// data building using builder
		OrderEntity entity = OrderEntity.builder().price(request.getPrice()).produceName(request.getProduceName())
				.build();

		return repository.save(entity);
	}

	@Override
	public OrderEntity findOrderById(Long id)
	{
		OrderEntity response = repository.findById(id).orElseThrow(() -> new RuntimeException("Order Id not found"));
		return response;
	}

	@Override
	public List<OrderEntity> findAll()
	{
		List<OrderEntity> respose = repository.findAll();
		return respose;
	}

}
