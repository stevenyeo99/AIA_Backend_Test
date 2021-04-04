package com.hubbers.aia.steven.backend.test.assembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.hubbers.aia.steven.backend.test.controller.FlickrController;
import com.hubbers.aia.steven.backend.test.model.Items;

@Component
public class FlickrAssembler implements RepresentationModelAssembler<Items, EntityModel<Items>> {
	
	@Override
	public EntityModel<Items> toModel(Items items) {
		
		return EntityModel.of(items,
				linkTo(methodOn(FlickrController.class).search(items.getAuthorId(), null, null, null)).withSelfRel().expand(),
				linkTo(methodOn(FlickrController.class).searchAndStore(items.getAuthorId(), null, null, null)).withRel("SearchAndInsert").expand(),
				linkTo(methodOn(FlickrController.class).search(null, null, null, null)).withRel("SearchAll").expand(),
				linkTo(methodOn(FlickrController.class).clean(items.getAuthorId(), null)).withRel("Clean").expand());
	}
}
