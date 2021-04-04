package com.hubbers.aia.steven.backend.test.service;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.util.List;
import java.util.stream.Collectors;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hubbers.aia.steven.backend.test.assembler.FlickrAssembler;
import com.hubbers.aia.steven.backend.test.controller.FlickrController;
import com.hubbers.aia.steven.backend.test.model.Flickr;
import com.hubbers.aia.steven.backend.test.model.Items;
import com.hubbers.aia.steven.backend.test.utility.SearchParam;
import com.hubbers.aia.steven.backend.test.repository.FlickrRepository;

@Service
public class FlickrService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FlickrService.class);
	
	private final String FLICKR_API = "https://www.flickr.com/services/feeds/photos_public.gne?format=json&nojsoncallback=1";
	
	@Autowired
	private FlickrRepository flickrRepository;
	
	private final RestTemplate restTemplate;
	
	@Autowired
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
	public CollectionModel<EntityModel<Items>> search(SearchParam searchParam, boolean isStore) {
		
		CollectionModel<EntityModel<Items>> responseEntity = null;
		
		Flickr flickr = getObjectFromAPI(searchParam);
		
		if (flickr != null) {
			List<EntityModel<Items>> items = flickr.getItems().stream()
					.map(flickrAssembler::toModel)
					.collect(Collectors.toList());
			
			responseEntity = CollectionModel.of(items, 
					linkTo(methodOn(FlickrController.class).search(null, null, null, null)).withSelfRel().expand(),
					linkTo(methodOn(FlickrController.class).searchAndStore(null, null, null, null)).withSelfRel().expand(),
					linkTo(methodOn(FlickrController.class).clean(null, null)).withSelfRel().expand()
				);
			
			if (isStore) {
				storeFlickrData(flickr);
			}
		}
		
		return responseEntity;
	}
	
	/**
	 * call Flickr API retrieve data services
	 * 
	 * @return
	 */
	private Flickr getObjectFromAPI(SearchParam searchParam) {
		
		String addParam = "";
		StringBuilder stringBuilder = null;
		if (searchParam != null) {
			stringBuilder = new StringBuilder();
			
			if (searchParam.getIds() != null && !searchParam.getIds().isEmpty()) {
				stringBuilder.append("&ids=" + searchParam.getIds());
			} else if (searchParam.getId() != null && !searchParam.getId().isEmpty()) {
				stringBuilder.append("&id=" + searchParam.getId());
			}
			
			if (searchParam.getTags() != null && !searchParam.getTags().isEmpty()) {
				stringBuilder.append("&tags=" + searchParam.getTags());
			}
			
			if (searchParam.getTagmode() != null && !searchParam.getTagmode().isEmpty()) {
				stringBuilder.append("&tagmode=" + searchParam.getTagmode());
			}
			
			addParam = stringBuilder.toString();
		}
		
		Flickr flickr = null;
		
		try {
			flickr = this.restTemplate.getForObject((FLICKR_API + addParam), Flickr.class);
			
			setMediaParentRelation(flickr);
			
			LOGGER.info("Success retrieve data from Flickr API.");
		} catch (Exception e) {
			LOGGER.error("Cannot retrieve data from Flickr API.");
		}
		
		return flickr;
	}
	
	/**
	 * Map parent object to media
	 * 
	 * @param flickr
	 */
	private void setMediaParentRelation(Flickr flickr) {
		for (Items items : flickr.getItems()) {
			items.getMedia().setItems(items);
		}
	}
	
	/**
	 * Storing Pulled Flickr data to database
	 * 
	 * @param flickr
	 * @return
	 */
	@Transactional
	private void storeFlickrData(Flickr flickr) {
		
		try {
			flickrRepository.saveAll(flickr.getItems());
			LOGGER.info("Success while storing flickr data into database.");
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Error while storing flickr data into database.");
		}
	}
	
	/**
	 * Delete flickr data by author id
	 * 
	 * @param authorId
	 */
	@Transactional
	public void deleteFlickrData(String authorId) {
		
		try {
			if (authorId != null) {
				String[] authorIdArray = authorId.split(",");
				if (authorIdArray.length > 1) {
					for (String author : authorIdArray) {
						flickrRepository.deleteByAuthorId(authorId);
					}
				} else if (authorId != null) {
					flickrRepository.deleteByAuthorId(authorId);
				}
			} else {
				flickrRepository.deleteAll();
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Error while deleting flickr data into database.");
		}
	}
}
