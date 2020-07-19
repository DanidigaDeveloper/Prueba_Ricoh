package com.DanidigaDeveloper.app;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.DanidigaDeveloper.app.controller.OrderController;
import com.DanidigaDeveloper.app.entity.Catalogue;
import com.DanidigaDeveloper.app.entity.Order;
import com.DanidigaDeveloper.app.entity.Product;
import com.DanidigaDeveloper.app.repository.OrderRepository;
import com.DanidigaDeveloper.app.service.OrderService;

class OrderTest {
	
	@Autowired
	private OrderService orderService; 
			
	@Test
	void testCreateOrder() {
		//ResponseEntity respuesta = oService.save(order);
	}
	
	@Test
	void testReadOrder() {
				
		Optional <Order> optOrder = orderService.findById((long) 1);
		Order orderTest = new Order((long) 1, "Pedido 1", null);
		assertEquals(orderTest, optOrder);
	}

}
