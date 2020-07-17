package com.DanidigaDeveloper.app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.authentication.UserServiceBeanDefinitionParser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DanidigaDeveloper.app.entity.Order;
import com.DanidigaDeveloper.app.service.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	//CREATE a new Order
	@PostMapping
	public ResponseEntity<?> create (@RequestBody Order order) {
		
		//Recibe en el cuerpo de la petición, un pedido, lo guardamos y devolvemos un codigo de estado de que se ha creado correctamente.
		return ResponseEntity.status(HttpStatus.CREATED).body(orderService.save(order));	
	}
	
	//READ a Order
	@GetMapping("/{id}")
	public ResponseEntity<?> read (@PathVariable Long id) {
		Optional <Order> optOrder = orderService.findById(id);	
		
		//Si no encontramos el Pedido devolvemos error (404 Not Found).
		if(!optOrder.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		//Si lo encuentra, devolvemos el Pedido.
		return ResponseEntity.ok(optOrder);
		
	}

}
