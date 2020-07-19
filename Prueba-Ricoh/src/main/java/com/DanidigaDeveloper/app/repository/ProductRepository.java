package com.DanidigaDeveloper.app.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;
import com.DanidigaDeveloper.app.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>, QueryByExampleExecutor<Product> {
    Page<Product> findByCatalogueId(Long catalogue_id, Pageable pageable);
}