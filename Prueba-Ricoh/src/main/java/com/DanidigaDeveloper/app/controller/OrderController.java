package com.DanidigaDeveloper.app.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DanidigaDeveloper.app.entity.Order;
import com.DanidigaDeveloper.app.service.OrderService;

@RestController
@RequestMapping("/api/order")
public class OrderController {
	
	private final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);
	
	@Autowired
	private OrderService orderService;
	
	//CREATE a new Order
	@PostMapping
	public ResponseEntity<?> create (@RequestBody Order order) {
		
		//Recibe en el cuerpo de la petición, un pedido, lo guardamos y devolvemos un codigo de estado de que se ha creado correctamente.
		LOGGER.debug("[create]: Order created");
		return ResponseEntity.status(HttpStatus.CREATED).body(orderService.save(order));	
	}
	
	//READ a Order
	@GetMapping("order/{id}")
	public ResponseEntity<?> readOrder (@PathVariable Long id) {
		
		Optional <Order> optOrder = orderService.findById(id);	
		
		//Si no encontramos el Pedido devolvemos error (404 Not Found).
		if(!optOrder.isPresent()) {
			LOGGER.debug("[readOrder]: Order not Found->",id);
			return ResponseEntity.notFound().build();
		}
		
		//Si lo encuentra, devolvemos el Pedido.
		LOGGER.debug("[readOrder]: Product Found->",id);
		return ResponseEntity.ok(optOrder);
		
	}
}
