package com.product.service;

import com.product.entity.ProductEntity;
import com.product.request.ProductRequest;

public interface ProductService
{
	public ProductEntity createNewProduct(ProductRequest request);

	public ProductEntity findProductById(Long id);
}
