package com.notification.consumer.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.notification.event.NotificationEvent;

@Component
public class NotificationConsumerService
{
	@KafkaListener(topics = "Event_Product_Service", groupId = "Event-notification-grp")
	public void consumer(NotificationEvent event)
	{
		System.out.println("Producer ID " + event.getProductId());
		System.out.println("Name " + event.getName());
		System.out.println("Status " + event.getStatus());
		System.out.println("Qty " + event.getQty());
	}
}
