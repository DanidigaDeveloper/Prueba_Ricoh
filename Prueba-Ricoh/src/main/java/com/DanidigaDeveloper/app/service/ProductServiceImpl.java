package com.DanidigaDeveloper.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.DanidigaDeveloper.app.entity.Order;
import com.DanidigaDeveloper.app.entity.Product;
import com.DanidigaDeveloper.app.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Product> findAll() {
		
		return productRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Product> findById(Long id) {
		
		return productRepository.findById(id);
	}

	@Override
	@Transactional
	public Product save(Product order) {
		
		return productRepository.save(order);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		
		productRepository.deleteById(id);
	}

}
