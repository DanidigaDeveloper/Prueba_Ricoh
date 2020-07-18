package com.DanidigaDeveloper.app.controller;

import com.DanidigaDeveloper.app.entity.Product;
import com.DanidigaDeveloper.app.service.ProductService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/product")
public class ProductController
{
	private final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	private ProductService productService;

	//READ ALL Products
	@GetMapping()
	public List<Product> retrieveAllProducts() {
		LOGGER.debug("[retrieveAllProducts]: INIT");
		return productService.findAll();
	}

	//READ a Product
	@GetMapping("product/{id}")
	public ResponseEntity<?> readProduct (@PathVariable Long id)
	{
		Optional <Product> optProduct = productService.findById(id);	
			
		//Si no encontramos el Articulo devolvemos error (404 Not Found).
		if(!optProduct.isPresent()) {
			LOGGER.debug("[readProduct]: Product not Found->",id);
			return ResponseEntity.notFound().build();
		}
		//Si lo encuentra, devolvemos el Articulo.
		LOGGER.debug("[readProduct]: Product Found->",id);
		return ResponseEntity.ok(optProduct);
	}
}

