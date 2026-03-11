package com.product.service;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.header.internals.RecordHeader;
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

	// Topic name.
	private static final String topic = "Event_Product_Service";
	// 1min in milliseconds (TTL- Time to live)
//	private static final Long ttl_ms = 1 * 60 * 1000l;

	// 3sec in milliseconds (TTL- Time to live)
	private static final Long ttl_ms = 3 * 1000l;

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

		// Build a producer record with TTL header
		Long expiryTime = System.currentTimeMillis() + ttl_ms;

		ProducerRecord<String, ProductEntity> record = new ProducerRecord(topic, null, System.currentTimeMillis(),
				String.valueOf(entity.getProductId()), entity);

		record.headers().add(new RecordHeader("ttl_expiry", String.valueOf(expiryTime).getBytes()));

//		template.send("Event_Product_Service", entity);
		template.send(record);

		return entity;
	}

}
