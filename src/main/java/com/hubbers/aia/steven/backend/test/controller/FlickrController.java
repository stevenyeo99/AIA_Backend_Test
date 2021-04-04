package com.hubbers.aia.steven.backend.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hubbers.aia.steven.backend.test.exception.FlickrNotFoundException;
import com.hubbers.aia.steven.backend.test.model.Items;
import com.hubbers.aia.steven.backend.test.utility.SearchParam;
import com.hubbers.aia.steven.backend.test.service.FlickrService;
import com.hubbers.aia.steven.backend.test.utility.ResponseStatus;

@CrossOrigin
@RestController
public class FlickrController {
	
	@Autowired
	private FlickrService service;
	
	@GetMapping("/search")
	public CollectionModel<EntityModel<Items>> search(
		@RequestParam(value = "id", required = false) String id,
		@RequestParam(value = "ids", required = false) String ids,
		@RequestParam(value = "tags", required = false) String tags,
		@RequestParam(value = "tagMode", required = false) String tagMode) 
	{
		
		SearchParam searchParam = getSearchParam(id, ids, tags, tagMode);
		
		CollectionModel<EntityModel<Items>> responseEntity = service.search(searchParam, false);
		
		if (responseEntity == null) {
			throw new FlickrNotFoundException();
		}
		
		return responseEntity;
	}
	
	@GetMapping("/searchAndstore")
	public CollectionModel<EntityModel<Items>> searchAndStore(
		@RequestParam(value = "id", required = false) String id,
		@RequestParam(value = "ids", required = false) String ids,
		@RequestParam(value = "tags", required = false) String tags,
		@RequestParam(value = "tagMode", required = false) String tagMode) 
	{
		
		SearchParam searchParam = getSearchParam(id, ids, tags, tagMode);
		
		CollectionModel<EntityModel<Items>> responseEntity = service.search(searchParam, true);
		
		if (responseEntity == null) {
			throw new FlickrNotFoundException();
		}
		
		return responseEntity;
	}
	
	@DeleteMapping("/clean")
	public ResponseEntity<?> clean(@RequestParam(value = "id", required = false) String id,
			@RequestParam(value = "ids", required = false) String ids) {
		
		String deleteId = null;
		
		if (id != null) {
			deleteId = id;
		}
		
		// prioritise delete the list of author's
		if (ids != null && !ids.isEmpty()) {
			deleteId = ids;
		}
		
		service.deleteFlickrData(deleteId);
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ResponseStatus("Successfull clear the data."));
	}
	
	/**
	 * Get & Setter search param utility
	 * 
	 * @param id
	 * @param tags
	 * @param tagMode
	 * @return
	 */
	private SearchParam getSearchParam(String id, String ids, String tags, String tagMode) {
		SearchParam searchParam = new SearchParam(id, ids, tags, tagMode, null, null);
				
		return searchParam;
	}
}
