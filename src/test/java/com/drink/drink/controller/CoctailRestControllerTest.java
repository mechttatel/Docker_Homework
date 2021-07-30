package com.drink.drink.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.drink.drink.dto.Cocktail.CocktailDtoCreate;
import com.drink.drink.dto.Cocktail.CocktailDtoForGetAll;
import com.drink.drink.service.CocktailService;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CoctailRestControllerTest extends BaseRestControllerTest {

	@Autowired
    CocktailService cocktailService;
	
	@Autowired
	private MockMvc mockMvc;
	
//    public void index() throws Exception {
//    	this.mockMvc
//	        .perform(get("/cocktails"))
//	        .andExpect(status().isOk())
//	        .andExpect(content().contentType(TestUtil.APPLICATION_JSON_UTF8))
//	        .andExpect(jsonPath("$[0].id", is(1)))
//	        .andExpect(jsonPath("$[*]", hasSize(20)));
//    }
    
    @Test
    public void existUserfind() throws Exception {
//    	CocktailDtoForGetAll cocktail = cocktailService.getAll().get(0);
//    	if (cocktail != null) {
//        	this.mockMvc
//            	.perform(get(String.format("/cocktails/%s", cocktail.getId())))
//            	.andExpect(status().isOk())
//            	.andExpect(content().contentType(TestUtil.APPLICATION_JSON_UTF8))
//            	.andExpect(jsonPath("$.id", is(cocktail.getId())));
//    	}
    }
    
    @Test
    public void missingUserfind() throws Exception {
//    	CocktailDtoForGetAll cocktail = cocktailService.getAll().get(0);
//    	if (cocktail != null) {
//        	this.mockMvc
//            	.perform(get(String.format("/cocktails/%s", -1)))
//            	.andExpect(status().is4xxClientError());
//    	}
    }
    
    @Test
    public void newCocktail() throws Exception {
//        ObjectMapper objectMapper = new ObjectMapper();
//        String newCocktail = objectMapper.writeValueAsString(getNewCocktail());
//
//        mockMvc.perform(
//            post("/cocktails")
//                    .contentType(MediaType.APPLICATION_JSON)
//                    .content(newCocktail))
//            .andExpect(status().isOk())
//            .andReturn();
    }
    

	private CocktailDtoCreate getNewCocktail() {
		CocktailDtoCreate cocktailDto = new CocktailDtoCreate();
    	cocktailDto.setAlcohol(40);
    	cocktailDto.setName("bad");
    	cocktailDto.setComment("Vicktor");
    	cocktailDto.setPhotoUrl("https://media-cdn.tripadvisor.com/media/photo-s/13/5e/5f/c8/blackcurrant-spritz-17.jpg");

    	List<Integer> list = new ArrayList<>();
    	list.add(1);
    	cocktailDto.setIngredientList(list);
    	cocktailDto.setRiceptList(list);
    	cocktailDto.setTagList(list);
    	return cocktailDto;
	}
	
	@Test 
	public void updtateExistCocktail() throws Exception {
//		CocktailDtoForGetAll cocktail = cocktailService.getAll().get(0);
//    	if (cocktail != null) {
//    		String newName = cocktail.getName() + "1";
//    		CocktailDtoCreate cocktailUpdata = getNewCocktail();
//    		cocktailUpdata.setName(newName);
//
//    		ObjectMapper objectMapper = new ObjectMapper();
//
//            String newCocktail = objectMapper.writeValueAsString(cocktailUpdata);
//
//        	mockMvc.perform(
//                    patch(String.format("/cocktails/%d", cocktail.getId()))
//                            .contentType(MediaType.APPLICATION_JSON)
//                            .content(newCocktail))
//                    .andExpect(status().isOk())
//                    .andReturn();
//
//        	String savedName = cocktailService.getCocktail(cocktail.getId()).getName();
//        	assertEquals(savedName,  newName);
//    	}
	}
	
	@Test
	public void removeExistCocktail() throws Exception {
//		CocktailDtoForGetAll cocktail = cocktailService.getAll().get(0);
//    	if (cocktail != null) {
//    		ObjectMapper objectMapper = new ObjectMapper();
//            String newCocktail = objectMapper.writeValueAsString(cocktail);
//
//
//        	mockMvc.perform(
//                    delete(String.format("/cocktails/%d", cocktail.getId()))
//                            .contentType(MediaType.APPLICATION_JSON)
//                            .content(newCocktail))
//                    .andExpect(status().isOk())
//                    .andReturn();
//    	}
	}
    
	private static class TestUtil {
		public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(),
				MediaType.APPLICATION_JSON.getSubtype());
	}
}
