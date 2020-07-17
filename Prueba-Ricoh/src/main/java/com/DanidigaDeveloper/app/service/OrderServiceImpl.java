package com.DanidigaDeveloper.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.DanidigaDeveloper.app.entity.Order;
import com.DanidigaDeveloper.app.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Order> findAll() {
		
		return orderRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Order> findById(Long id) {
		
		return orderRepository.findById(id);
	}

	@Override
	@Transactional
	public Order save(Order order) {
		
		return orderRepository.save(order);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		
		orderRepository.deleteById(id);
	}

}
