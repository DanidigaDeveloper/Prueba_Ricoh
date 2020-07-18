package com.DanidigaDeveloper.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.DanidigaDeveloper.app.entity.Catalogue;
import com.DanidigaDeveloper.app.repository.CatalogueRepository;

public class CatalogueServiceImpl implements CatalogueService{

	@Autowired
	private CatalogueRepository catalogueRepository;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Catalogue> findAll() {
		return catalogueRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Catalogue> findById(Long id) {
		return catalogueRepository.findById(id);
	}

	@Override
	@Transactional
	public Catalogue save(Catalogue catalogue) {
		return catalogueRepository.save(catalogue);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		catalogueRepository.deleteById(id);	
	}
}
