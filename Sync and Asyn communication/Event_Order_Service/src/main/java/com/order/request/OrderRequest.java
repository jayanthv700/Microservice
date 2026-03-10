package com.order.request;

import lombok.Data;

@Data
public class OrderRequest
{
	private Long productId;
	private Integer qty;
}
