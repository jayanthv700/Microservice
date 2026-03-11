package com.notification.consumer.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.header.Header;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.notification.event.NotificationEvent;

@Component
public class NotificationConsumerService
{
	@KafkaListener(topics = "Event_Product_Service", groupId = "Event-notification-grp")
//	public void consumer(NotificationEvent event)
//	{
//		System.out.println("Producer ID " + event.getProductId());
//		System.out.println("Name " + event.getName());
//		System.out.println("Status " + event.getStatus());
//		System.out.println("Qty " + event.getQty());
//	}
	public void consumer(ConsumerRecord<String, NotificationEvent> record)
	{
		Header ttlHeader = record.headers().lastHeader("ttl_expiry");

		if (ttlHeader != null)
		{
			Long expireTime = Long.parseLong(new String(ttlHeader.value()));

			// Check if the message is expired or not
			if (System.currentTimeMillis() > expireTime)
			{
				System.out.println(" Message expired! Skipping ProductID: " + record.value().getProductId());
				return;
			}
		}

		// message valid
		NotificationEvent event = record.value();
		System.out.println("Producer ID " + event.getProductId());
		System.out.println("Name " + event.getName());
		System.out.println("Status " + event.getStatus());
		System.out.println("Qty " + event.getQty());
	}
}
