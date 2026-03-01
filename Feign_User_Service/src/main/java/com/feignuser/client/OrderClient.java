package com.feignuser.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.feignuser.dto.OrderEvent;

@FeignClient(name = "feign-order-service")
public interface OrderClient
{
	@GetMapping("/order/get/{id}")
	OrderEvent findOrderById(@PathVariable Long id);
}
