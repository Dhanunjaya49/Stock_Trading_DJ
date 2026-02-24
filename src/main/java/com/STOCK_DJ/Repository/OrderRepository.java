package com.STOCK_DJ.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.STOCK_DJ.model.Order;

public interface OrderRepository extends JpaRepository<Order,Long> {

	List<Order> findByUserId(Long userid);


}
