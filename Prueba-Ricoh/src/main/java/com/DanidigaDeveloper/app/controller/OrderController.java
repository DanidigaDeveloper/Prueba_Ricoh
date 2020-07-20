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
import org.springframework.web.bind.annotation.RequestMethod;
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
		LOGGER.debug("[create]: Order create : INIT : {}", order);
		
		LOGGER.debug("[create]: order.getItems() {}", order.getItems());
		
		// Required by Hibernate ORM to save properly
		if(order.getItems() !=null){
			order.getItems().forEach(item -> item.setOrder(order));
		}
		Order createdOrder = orderService.save(order);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdOrder.getId());	
	}
	
	//READ a Order
	@GetMapping("{id}")
	public ResponseEntity<?> read (@PathVariable Long id) {
		
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
	
	// UPDATE a Order
	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public Order edit(@PathVariable("id") long id, @RequestBody Order order){
		Optional<Order> updatedOrder = orderService.findById(id);
		if(!updatedOrder.isPresent()){
			return null;
		}
		order.setId(id);
		return orderService.save(order);
	}

	// DELETE a Order
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable("id") long id){
		orderService.deleteById(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
