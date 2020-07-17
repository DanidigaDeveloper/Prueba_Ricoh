package com.DanidigaDeveloper.app.service;

import java.util.Optional;
import com.DanidigaDeveloper.app.entity.Product;

public interface ProductService {

public Iterable<Product> findAll();
	
	public Optional<Product> findById(Long Id);
	
	public Product save(Product order);
	
	public void deleteById(Long id);
}
