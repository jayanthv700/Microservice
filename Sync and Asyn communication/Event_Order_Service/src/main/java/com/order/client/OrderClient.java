package com.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.order.dto.ProductDto;

@FeignClient(name = "event-product-service", fallback = OrderClientFallback.class)
public interface OrderClient
{
	@GetMapping("/product/find/{id}")
	public ProductDto findById(@PathVariable Long id);
}
