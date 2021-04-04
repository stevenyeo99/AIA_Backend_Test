package com.hubbers.aia.steven.backend.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hubbers.aia.steven.backend.test.model.Items;

public interface FlickrRepository extends JpaRepository<Items, Long> {
	
	Long deleteByAuthorId(String authorId);
}
