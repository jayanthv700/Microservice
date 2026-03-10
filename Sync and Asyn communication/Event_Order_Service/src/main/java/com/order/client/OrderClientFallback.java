package com.order.client;

import org.springframework.context.annotation.ComponentScan;

import com.order.dto.ProductDto;

@ComponentScan
public class OrderClientFallback implements OrderClient
{

	@Override
	public ProductDto findById(Long id)
	{
		ProductDto fallback = new ProductDto();
		fallback.setProductId(id);
		fallback.setName("Product Unavailiable");
		fallback.setQty(0);
		fallback.setStatus("Service_Down");
		return fallback;
	}

}
