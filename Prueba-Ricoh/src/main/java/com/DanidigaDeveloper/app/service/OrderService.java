package com.DanidigaDeveloper.app.service;

import java.util.Optional;

import com.DanidigaDeveloper.app.entity.Order;

public interface OrderService {

	public Iterable<Order> findAll();
	
	public Optional<Order> findById(Long Id);
	
	public Order save(Order order);
	
	public void deleteById(Long id);
}
