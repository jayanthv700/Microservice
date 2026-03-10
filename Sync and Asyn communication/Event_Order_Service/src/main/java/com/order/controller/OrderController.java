package com.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.dto.ProductDto;
import com.order.request.OrderRequest;
import com.order.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController
{
	@Autowired
	OrderService service;

	@PostMapping("/create")
	public ResponseEntity<ProductDto> createOrder(@RequestBody OrderRequest request)
	{
		ProductDto dto = service.createNewOrder(request);
		return ResponseEntity.status(HttpStatus.CREATED).body(dto);
	}
}
