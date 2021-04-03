package com.hubbers.aia.steven.backend.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.hubbers.aia.steven.backend.test.model.Items;
import com.hubbers.aia.steven.backend.test.service.FlickrService;

@RestController
public class FlickrController {
	
	@Autowired
	private FlickrService service;
	
	@GetMapping("/flickrFeed")
	public CollectionModel<EntityModel<Items>> searchAll() {
		
		CollectionModel<EntityModel<Items>> responseEntity = service.search();
		
		return responseEntity;
	}
	
	@GetMapping("/flickrFeed/{id}")
	public CollectionModel<EntityModel<Items>> searchByAuthorId(@PathVariable String id) {
		
		CollectionModel<EntityModel<Items>> responseEntity = service.search();
		
		return responseEntity;
	}
}
