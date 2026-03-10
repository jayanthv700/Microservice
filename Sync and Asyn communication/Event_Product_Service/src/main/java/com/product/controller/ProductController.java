package com.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.entity.ProductEntity;
import com.product.request.ProductRequest;
import com.product.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController
{
	@Autowired
	ProductService service;

	@PostMapping("/create")
	public ResponseEntity<ProductEntity> createProduct(@RequestBody ProductRequest request)
	{
		ProductEntity entity = service.createNewProduct(request);
		return ResponseEntity.status(HttpStatus.CREATED).body(entity);
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<ProductEntity> findById(@PathVariable Long id)
	{
		ProductEntity entity = service.findProductById(id);
		return ResponseEntity.ok(entity);
	}
}
