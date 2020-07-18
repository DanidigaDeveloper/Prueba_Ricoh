package com.DanidigaDeveloper.app.service;

import java.util.Optional;
import com.DanidigaDeveloper.app.entity.Catalogue;

public interface CatalogueService {

	public Iterable<Catalogue> findAll();
	
	public Optional<Catalogue> findById(Long Id);
	
	public Catalogue save(Catalogue catalogue);
	
	public void deleteById(Long id);
}
