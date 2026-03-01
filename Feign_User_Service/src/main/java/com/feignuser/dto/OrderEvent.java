package com.feignuser.dto;

import lombok.Data;

@Data
public class OrderEvent
{
	private Long id;
	private String productName;
	private Double price;
}
