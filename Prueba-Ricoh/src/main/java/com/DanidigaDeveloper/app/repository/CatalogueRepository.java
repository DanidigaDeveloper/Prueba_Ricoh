package com.DanidigaDeveloper.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.DanidigaDeveloper.app.entity.Catalogue;

@Repository
public interface CatalogueRepository extends JpaRepository<Catalogue, Long>{

}
