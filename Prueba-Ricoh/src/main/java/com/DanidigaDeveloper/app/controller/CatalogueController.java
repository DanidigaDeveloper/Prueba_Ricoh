package com.DanidigaDeveloper.app.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DanidigaDeveloper.app.entity.Catalogue;
import com.DanidigaDeveloper.app.service.CatalogueService;
import com.DanidigaDeveloper.app.service.ProductService;

@RestController
@RequestMapping("/api/catalogue")
public class CatalogueController {

	private final Logger LOGGER = LoggerFactory.getLogger(CatalogueController.class);
	
	@Autowired
	private CatalogueService catalogueService;
	
	@Autowired
	private ProductService productService;
	
	
	//READ ALL Products
	@GetMapping()
	public List<Catalogue> retrieveAllCatalogues() {
		LOGGER.debug("[retrieveAllCatalogues]: INIT");
		return catalogueService.findAll();
	}
		
	//READ a Catalogue
	@GetMapping("{id}")
	public ResponseEntity<?> readCatalogue (@PathVariable Long id)
	{
		Optional <Catalogue> optCatalogue = catalogueService.findById(id);	
				
		//Si no encontramos el Catálogo devolvemos error (404 Not Found).
		if(!optCatalogue.isPresent()) {
			LOGGER.debug("[readCatalogue]: Catalogue not Found->",id);
			return ResponseEntity.notFound().build();
		}
		//Si lo encuentra, devolvemos el Catálogo.
		LOGGER.debug("[readCatalogue]: Catalogue Found->",id);
		return ResponseEntity.ok(optCatalogue);
	}
}
