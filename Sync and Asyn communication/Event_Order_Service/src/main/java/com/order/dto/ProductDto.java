package com.order.dto;

import lombok.Data;

@Data
public class ProductDto
{
	private Long productId;
	private String name;
	private Integer qty;
	private String status;
}
