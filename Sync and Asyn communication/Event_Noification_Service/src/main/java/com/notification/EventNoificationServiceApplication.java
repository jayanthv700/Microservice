package com.notification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class EventNoificationServiceApplication
{

	public static void main(String[] args)
	{
		SpringApplication.run(EventNoificationServiceApplication.class, args);
	}

}
