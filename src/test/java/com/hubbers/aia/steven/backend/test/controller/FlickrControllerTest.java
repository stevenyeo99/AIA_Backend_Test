package com.hubbers.aia.steven.backend.test.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class FlickrControllerTest {
	
	private final String TEST_AUTHOR_ID = "55818546@N00";
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void testSearchAll()
		throws Exception {
		MvcResult mvcResult = this.mockMvc.perform(get("/search")).andReturn();
		
		assertThat(mvcResult.getResponse().getStatus() == 200).isTrue();
		
		assertThat(mvcResult.getResponse().toString()).isNotNull();
	}
	
	@Test
	public void testSearchByAuthorId()
		throws Exception {
		MvcResult mvcResult = this.mockMvc.perform(get("/search?id="+TEST_AUTHOR_ID)).andReturn();
		
		assertThat(mvcResult.getResponse().getStatus() == 200).isTrue();
	
		assertThat(mvcResult.getResponse().toString()).isNotNull();
	}
	
	@Test
	public void testSearchAndInsert()
		throws Exception {
		MvcResult mvcResult = this.mockMvc.perform(get("/searchAndstore")).andReturn();
		
		assertThat(mvcResult.getResponse().getStatus() == 200).isTrue();
		
		assertThat(mvcResult.getResponse().toString()).isNotNull();
	}
	
	@Test
	public void testSearchAndInsertByAuthorId() 
		throws Exception {
		MvcResult mvcResult = this.mockMvc.perform(get("/searchAndstore?id="+TEST_AUTHOR_ID)).andReturn();
		
		assertThat(mvcResult.getResponse().getStatus() == 200).isTrue();
		
		assertThat(mvcResult.getResponse().toString()).isNotNull();
	}
	
	@Test
	public void testClean()
		throws Exception {
		MvcResult mvcResult = this.mockMvc.perform(delete("/clean")).andReturn();
		
		assertThat(mvcResult.getResponse().getStatus() == 202).isTrue();
		
		assertThat(mvcResult.getResponse().toString()).isNotNull();
	}
	
	@Test
	public void testCleanByAuthorId()
		throws Exception {
		MvcResult mvcResult = this.mockMvc.perform(delete("/clean?id="+TEST_AUTHOR_ID)).andReturn();
		
		assertThat(mvcResult.getResponse().getStatus() == 202).isTrue();
		
		assertThat(mvcResult.getResponse().toString()).isNotNull();
	}
}
