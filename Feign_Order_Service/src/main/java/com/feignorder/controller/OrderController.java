package com.feignorder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.feignorder.dto.OrderRequest;
import com.feignorder.model.OrderEntity;
import com.feignorder.service.OrderService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController
{
	@Autowired
	OrderService service;

	@PostMapping("/create")
	public ResponseEntity<OrderEntity> createNewOrder(@RequestBody OrderRequest request)
	{
		log.info("Inside createNewOrder method");
		OrderEntity entity = service.createOrder(request);
		return ResponseEntity.status(HttpStatus.CREATED).body(entity);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<OrderEntity> findOrderById(@PathVariable Long id)
	{
		log.info("Inside findOrderById method");
		OrderEntity entity = service.findOrderById(id);
		return ResponseEntity.ok(entity);
	}

	@GetMapping("/findall")
	public ResponseEntity<List<OrderEntity>> getMethodName(@RequestParam String param)
	{
		log.info("Inside getMethodName method");
		List<OrderEntity> entityList = service.findAll();
		return ResponseEntity.ok(entityList);
	}

}
