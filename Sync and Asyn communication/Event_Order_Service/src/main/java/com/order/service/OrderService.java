package com.order.service;

import com.order.dto.ProductDto;
import com.order.request.OrderRequest;

public interface OrderService
{
	public ProductDto createNewOrder(OrderRequest request);
}
