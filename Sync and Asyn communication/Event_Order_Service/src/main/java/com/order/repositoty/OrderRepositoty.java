package com.order.repositoty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.order.entity.OrderEntity;

@Repository
public interface OrderRepositoty extends JpaRepository<OrderEntity, Long>
{

}
