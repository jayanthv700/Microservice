package com.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.product.entity.ProductEntity;
import com.product.repository.ProductRepository;
import com.product.request.ProductRequest;

@Service
public class ProductServiceImpl implements ProductService
{
	@Autowired
	ProductRepository repository;

	@Autowired
	KafkaTemplate<String, ProductEntity> template;

	@Override
	public ProductEntity createNewProduct(ProductRequest request)
	{
		ProductEntity entity = new ProductEntity();
		entity.setName(request.getName());
		entity.setQty(request.getQty());
		entity.setStatus(request.getStatus());

		return repository.save(entity);
	}

	@Override
	public ProductEntity findProductById(Long id)
	{
		ProductEntity entity = repository.findById(id)
				.orElseThrow(() -> new RuntimeException("The product Id not found!!"));

		template.send("Event_Product_Service", entity);

		return entity;
	}

}
