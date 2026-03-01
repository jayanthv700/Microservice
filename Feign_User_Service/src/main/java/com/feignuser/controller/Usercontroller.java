package com.feignuser.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.feignuser.client.OrderClient;
import com.feignuser.dto.OrderEvent;
import com.feignuser.dto.UserRequest;
import com.feignuser.model.UserEntity;
import com.feignuser.service.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/user")
@Slf4j
public class Usercontroller
{
	@Autowired
	UserService service;

	@Autowired
	OrderClient orderClient;

	Long id;

	@PostMapping("/create")
	public ResponseEntity<UserEntity> createNewUser(@RequestBody UserRequest request)
	{
		log.info("Inside createNewUser method");
		UserEntity entity = service.createUser(request);
		return ResponseEntity.status(HttpStatus.CREATED).body(entity);
	}

	@GetMapping("get/{id}")
	public ResponseEntity<UserEntity> findUserById(@PathVariable Long id)
	{
		log.info("Inside findUserById method");
		UserEntity entity = service.getUserById(id);
		return ResponseEntity.ok(entity);
	}

//	@GetMapping("{userid}/order/get/{id}")
//	public String getUserDetailsById(@PathVariable Long userid, @PathVariable Long id);
//
//	{
//		OrderEvent event = orderClient.findOrderById(id);
//		return "User Id: " + id + " Product name: " + event.getProduceName() + " Price: " + event.getPrice();
//	}

	@GetMapping("{userid}/order/get/{id}")
	public ResponseEntity<?> getUserDetailsById(@PathVariable Long userid, @PathVariable Long id)
	{

		OrderEvent event = orderClient.findOrderById(id);

//		return ResponseEntity.ok(event);

		return ResponseEntity.ok(Map.of("userId", userid, "orderId", event.getId(), "productName",
				event.getProductName(), "price", event.getPrice()));
	}
}
