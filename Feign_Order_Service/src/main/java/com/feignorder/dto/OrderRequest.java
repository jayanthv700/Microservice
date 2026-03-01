package com.feignorder.dto;

import lombok.Data;

@Data
public class OrderRequest
{
	private String produceName;
	private Double price;
}
