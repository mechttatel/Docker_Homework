package com.drink.drink.service.impl;

import com.drink.drink.dto.composition.CompositionDto;
import com.drink.drink.dto.composition.CompositionDtoCreate;
import com.drink.drink.exception.NotFoundException;
import com.drink.drink.model.Composition;
import com.drink.drink.model.Ingredient;
import com.drink.drink.repository.CompositionRepository;
import com.drink.drink.repository.IngredientRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
@Transactional
@ActiveProfiles("myDb")
@AutoConfigureMockMvc
class CompositionServiceImplTest {

    @Autowired
    CompositionRepository compositionRepository;
    @Autowired
    IngredientRepository ingredientRepository;
    @Autowired
    CompositionServiceImpl compositionService;

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
        compositionList.add(composition2);

        Ingredient ingredient = new Ingredient();
        ingredient.setName("TEST");
        ingredient.setId(1);
        ingredientRepository.save(ingredient);
    }


    @Test
    void getComposition() {
        CompositionDto compositionDto = compositionService.getComposition(1);
        assertEquals(compositionDto.getUnit(), "test");
        assertEquals(compositionDto.getValue(), 50);


    }

    void addItem(List<?> list) {

    }

    @Test
    void getAll() {
        List<CompositionDto> compositionDto = compositionService.getAll();
        assertEquals(compositionDto.size(), 2);
        assertEquals(compositionDto.get(0).getUnit(), "test");
        assertEquals(compositionDto.get(0).getValue(), 50);
    }

    @Test
    void save() {
        CompositionDtoCreate compositionDtoCreate = new CompositionDtoCreate();
        compositionDtoCreate.setUnit("ml");
        compositionDtoCreate.setValue(100);
        compositionDtoCreate.setIngredientId(1);
        compositionService.save(compositionDtoCreate);

        CompositionDto compositionDto = compositionService.getComposition(3);
        assertEquals(compositionDto.getUnit(), "ml");
        assertEquals(compositionDto.getValue(), 100);
    }

    @Test
    void update() {

        CompositionDtoCreate compositionDtoCreate = new CompositionDtoCreate();
        compositionDtoCreate.setUnit("TEST_UPDATE");
        compositionDtoCreate.setValue(1000);
        compositionDtoCreate.setIngredientId(1);

        compositionService.update(1, compositionDtoCreate);
        CompositionDto compositionDto = compositionService.getComposition(1);
        assertEquals(compositionDto.getValue(), 1000);
        assertEquals(compositionDto.getUnit(), "TEST_UPDATE");
    }

    @Test
    void deleteTest() {
        compositionService.delete(1);
        List<CompositionDto> compositionDtoList = compositionService.getAll();
        assertEquals(compositionDtoList.size(), 1);
    }

    @Test
    void exceptionTest() throws NotFoundException {

        assertThrows(NotFoundException.class, () -> compositionService.delete(1000));
        assertThrows(NotFoundException.class, () -> compositionService.getComposition(1000));

        CompositionDtoCreate compositionDtoCreate = new CompositionDtoCreate();
        compositionDtoCreate.setUnit("ml");
        compositionDtoCreate.setValue(99);
        compositionDtoCreate.setIngredientId(1000);
        assertThrows(NotFoundException.class, () -> compositionService.save(compositionDtoCreate));

        CompositionDtoCreate compositionDtoCreate1 = new CompositionDtoCreate();
        compositionDtoCreate1.setUnit("m");
        compositionDtoCreate1.setValue(88);
        compositionDtoCreate1.setIngredientId(1);
        //assertThrows(NotFoundException.class, () -> compositionService.save(compositionDtoCreate1));

        CompositionDtoCreate compositionDtoCreate2 = new CompositionDtoCreate();
        compositionDtoCreate2.setUnit("ml");
        compositionDtoCreate2.setValue(111);
        compositionDtoCreate2.setIngredientId(1);
        //assertThrows(NotFoundException.class, () -> compositionService.save(compositionDtoCreate2));

        compositionService.delete(1);
        compositionService.delete(2);
        assertThrows(NotFoundException.class, () -> compositionService.getAll());


    }
}


/*        compositionDtoCreate.setIngredientId(1);
        compositionDtoCreate.setUnit("l");
        assertThrows(NotFoundException.class, () -> compositionService.save(compositionDtoCreate));

        compositionDtoCreate.setUnit("ml");
        compositionDtoCreate.setValue(222);
        assertThrows(NotFoundException.class, () -> compositionService.save(compositionDtoCreate));*/