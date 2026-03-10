package com.product.request;

import lombok.Data;

@Data
public class ProductRequest
{
	private String name;
	private Integer qty;
	private String status;
}
