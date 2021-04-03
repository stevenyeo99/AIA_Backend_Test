package com.hubbers.aia.steven.backend.test.service;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hubbers.aia.steven.backend.test.assembler.FlickrAssembler;
import com.hubbers.aia.steven.backend.test.controller.FlickrController;
import com.hubbers.aia.steven.backend.test.model.Flickr;
import com.hubbers.aia.steven.backend.test.model.Items;


@Service
public class FlickrService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FlickrService.class);
	
	private final String FLICKR_API = "https://www.flickr.com/services/feeds/photos_public.gne?format=json&nojsoncallback=1";
	
	private final RestTemplate restTemplate;
	
	private final FlickrAssembler flickrAssembler;
	
	public FlickrService(RestTemplateBuilder restTemplateBuilder, FlickrAssembler flickrAssembler) {
		this.restTemplate = restTemplateBuilder.build();
		this.flickrAssembler = flickrAssembler;
	}
	
	/**
	 * searching services
	 * 
	 * @return
	 */
	public CollectionModel<EntityModel<Items>> search() {
		
		CollectionModel<EntityModel<Items>> responseEntity = null;
		
		Flickr flickr = getObjectFromAPI();
		
		if (flickr != null) {
			List<EntityModel<Items>> items = flickr.getItems().stream()
					.map(flickrAssembler::toModel)
					.collect(Collectors.toList());
			
			responseEntity = CollectionModel.of(items, linkTo(methodOn(FlickrController.class).searchAll()).withSelfRel());
		}
		
		return responseEntity;
	}
	
	/**
	 * call flickr services
	 * 
	 * @return
	 */
	public Flickr getObjectFromAPI() {
		
		Flickr flickr = null;
		
		try {
			flickr = this.restTemplate.getForObject(FLICKR_API, Flickr.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return flickr;
	}
}
