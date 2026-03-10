package com.notification.event;

import lombok.Data;

@Data
public class NotificationEvent
{
	private Long productId;
	private String name;
	private Integer qty;
	private String status;
}
