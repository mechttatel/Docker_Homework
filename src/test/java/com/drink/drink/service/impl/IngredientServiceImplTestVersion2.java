package com.drink.drink.service.impl;

import com.drink.drink.dto.ingredient.IngredientDto;
import com.drink.drink.dto.ingredient.IngredientDtoCreate;
import com.drink.drink.exception.NotFoundException;
import com.drink.drink.model.Composition;
import com.drink.drink.model.Ingredient;
import com.drink.drink.repository.CompositionRepository;
import com.drink.drink.repository.IngredientRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
@Transactional
@ActiveProfiles("myDb")
class IngredientServiceImplTestVersion2 {


    @Autowired
    IngredientRepository ingredientRepository;
    @Autowired
    IngredientServiceImpl ingredientService;

    @BeforeAll
    static void createTestComposition(@Autowired
                                              CompositionRepository compositionRepository,
                                      @Autowired
                                              IngredientRepository ingredientRepository
    ) {

        Composition composition = new Composition();
        composition.setId(1);
        composition.setValue(50);
        composition.setUnit("test");
        composition.setIngredient(null);

        Composition composition2 = new Composition();
        composition.setId(2);
        composition.setValue(50);
        composition.setUnit("test");
        composition.setIngredient(null);

        compositionRepository.save(composition);
        compositionRepository.save(composition2);
        List<Composition> compositionList = new ArrayList<>();
        compositionList.add(composition);
        List<Composition> compositionList2 = new ArrayList<>();
        compositionList2.add(composition2);

        Ingredient ingredient = new Ingredient();
        ingredient.setName("TEST1");
        ingredient.setCompositionList(compositionList);
        ingredient.setCocktailList(null);
        ingredient.setId(1);


        Ingredient ingredient1 = new Ingredient();
        ingredient1.setName("TEST2");
        ingredient1.setCompositionList(compositionList2);
        ingredient1.setCocktailList(null);
        ingredient1.setId(2);

        ingredientRepository.save(ingredient);
        ingredientRepository.save(ingredient1);
    }


    @Test
    void getIngredientTest() {
        IngredientDto ingredientDto = ingredientService.getIngredient(1);
        assertNotNull(ingredientDto);
        assertEquals(ingredientDto.getName(), "TEST1");
    }

    @Test
    void getAll() {
        List<IngredientDto> ingredientDtoList = ingredientService.getAll();
        assertNotNull(ingredientDtoList);
        assertEquals(ingredientDtoList.size(), 2);
    }

    @Test
    void delete() {
        ingredientService.delete(2);
        List<IngredientDto> ingredientDtoList = ingredientService.getAll();
        assertNotNull(ingredientDtoList);
        assertEquals(ingredientDtoList.size(), 1);
    }

    @Test
    void create() {

        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);

        IngredientDtoCreate ingredient = new IngredientDtoCreate();
        ingredient.setName("TEST3");
        ingredient.setCompositionList(integerList);

        ingredientService.save(ingredient);

        List<IngredientDto> ingredientDtoList = ingredientService.getAll();
        IngredientDto ingredientDto = ingredientService.getIngredient(3);

        assertNotNull(ingredientDto);
        assertEquals(ingredientDto.getName(), "TEST3");
        assertEquals(ingredientDtoList.size(), 3);
    }

    @Test
    void update() {
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        IngredientDtoCreate ingredientDtoCreate = new IngredientDtoCreate();
        ingredientDtoCreate.setName("TESTUPDATE");
        ingredientDtoCreate.setCompositionList(integerList);

        ingredientService.update(2, ingredientDtoCreate);

        List<IngredientDto> ingredientDtoList = ingredientService.getAll();
        IngredientDto ingredientDto = ingredientService.getIngredient(2);

        assertNotNull(ingredientDto);
        assertEquals(ingredientDto.getName(), "TESTUPDATE");
        assertEquals(ingredientDtoList.size(), 2);
    }

    @Test
    void testException() throws NotFoundException {

        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);

        IngredientDtoCreate ingredient = new IngredientDtoCreate();
        ingredient.setName("TEST3");
        ingredient.setCompositionList(integerList);

        assertThrows(NotFoundException.class, () -> ingredientService.getIngredient(1000));
        assertThrows(NotFoundException.class, () -> ingredientService.delete(1000));
        assertThrows(NotFoundException.class, () -> ingredientService.update(30, ingredient));

        ingredientService.delete(1);
        ingredientService.delete(2);
        assertThrows(NotFoundException.class, () -> ingredientService.getAll());

    }


}
