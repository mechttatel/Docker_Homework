package com.drink.drink.service.impl;

import com.drink.drink.dto.ingredient.IngredientDto;
import com.drink.drink.dto.ingredient.IngredientDtoCreate;
import com.drink.drink.model.Composition;
import com.drink.drink.model.Ingredient;
import com.drink.drink.repository.CompositionRepository;
import com.drink.drink.repository.IngredientRepository;
import com.drink.drink.service.BaseTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
@Transactional
@ActiveProfiles("myDb")
class IngredientServiceImplTest extends BaseTest {

    @InjectMocks
    IngredientServiceImpl ingredientServiceMock;

    @Mock
    IngredientRepository ingredientRepositoryMock;
    @Mock
    CompositionRepository compositionRepository;
    private static List<Ingredient> ingredientList = new ArrayList<>();
    private static List<Composition> compositionList = new ArrayList<>();



    @BeforeAll
    static void setUp() {

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

        compositionList.add(composition);
        compositionList.add(composition2);

        Ingredient ingredient = new Ingredient();
        ingredient.setName("TEST1");
        ingredient.setCompositionList(compositionList);
        ingredient.setCocktailList(null);
        ingredient.setId(1);


        Ingredient ingredient1 = new Ingredient();
        ingredient1.setName("TEST2");
        ingredient1.setCompositionList(compositionList);
        ingredient1.setCocktailList(null);
        ingredient1.setId(2);

        ingredientList.add(ingredient);
        ingredientList.add(ingredient1);
    }


    @Test
    void getAllMock() {

        when(ingredientRepositoryMock.findAll())
                .thenReturn(ingredientList);

        List<IngredientDto> ingredientDtoList = ingredientServiceMock.getAll();

        assertNotNull(ingredientDtoList);
        assertEquals(ingredientDtoList.size(), ingredientList.size());
        assertEquals(ingredientDtoList.get(0).getName(), ingredientList.get(0).getName());

    }

    @Test
    void getIngredientMock() {

        when(ingredientRepositoryMock.findById(1))
                .thenReturn(Optional.of(ingredientList.get(0)));


        IngredientDto ingredientDto = ingredientServiceMock.getIngredient(1);

        assertNotNull(ingredientDto);
        assertEquals(IngredientDto.of(ingredientList.get(0)).getName(), ingredientDto.getName());
    }

    @Test
    void save() {
//        Composition composition = new Composition();
//        composition.setId(1);
//        composition.setValue(50);
//        composition.setUnit("test");
//        composition.setIngredient(null);
//
//        List<Composition> compositionList = new ArrayList<>();
//        compositionList.add(composition);
//
//        IngredientDtoCreate ingredientDtoCreate = new IngredientDtoCreate();
//        ingredientDtoCreate.setName("TEST1");
//        List<Integer> integerList = new ArrayList<>();
//        integerList.add(1);
//        integerList.add(2);
//
//
//        Ingredient ingredient = new Ingredient();
//        ingredient.setName("TEST1");
//        ingredient.setId(3);
//        ingredient.setCocktailList(null);
//        ingredient.setCompositionList(compositionList);
//
//        when(compositionRepository.findAllById(integerList))
//                .thenReturn(compositionList);
//        when(ingredientRepositoryMock.save(ingredient))
//                .thenReturn(ingredient);

/*        IngredientDtoCreate ingredientDtoCreate = new IngredientDtoCreate();
        ingredientDtoCreate.setName("TEST1");
        ingredientDtoCreate.setCompositionList(integerList);*/

        //ingredientServiceMock.save(ingredientDtoCreate);
    }


    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}

