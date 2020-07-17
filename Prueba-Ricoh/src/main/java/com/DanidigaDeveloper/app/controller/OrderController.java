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
import com.DanidigaDeveloper.app.entity.Product;
import com.DanidigaDeveloper.app.service.OrderService;
import com.DanidigaDeveloper.app.service.ProductService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private ProductService productService;
	
	
	//CREATE a new Order
	@PostMapping
	public ResponseEntity<?> create (@RequestBody Order order) {
		
		//Recibe en el cuerpo de la petición, un pedido, lo guardamos y devolvemos un codigo de estado de que se ha creado correctamente.
		return ResponseEntity.status(HttpStatus.CREATED).body(orderService.save(order));	
	}
	
	//READ a Order
	@GetMapping("order/{id}")
	public ResponseEntity<?> read (@PathVariable Long id) {
		Optional <Order> optOrder = orderService.findById(id);	
		
		//Si no encontramos el Pedido devolvemos error (404 Not Found).
		if(!optOrder.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		//Si lo encuentra, devolvemos el Pedido.
		return ResponseEntity.ok(optOrder);
		
	}
	
	//READ a Product
	@GetMapping("product/{id}")
	public ResponseEntity<?> readProduct (@PathVariable Long id) {
		Optional <Product> optProduct = productService.findById(id);	
			
		//Si no encontramos el Articulo devolvemos error (404 Not Found).
		if(!optProduct.isPresent()) {
			return ResponseEntity.notFound().build();
		}
			
		//Si lo encuentra, devolvemos el Articulo.
		return ResponseEntity.ok(optProduct);
			
	}

}
