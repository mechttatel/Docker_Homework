package com.drink.drink.service.impl;

import com.drink.drink.dto.ingredient.IngredientDto;
import com.drink.drink.dto.ingredient.IngredientDtoCreate;
import com.drink.drink.exception.ListIsEmptyException;
import com.drink.drink.exception.NotFoundException;
import com.drink.drink.model.Cocktail;
import com.drink.drink.model.Composition;
import com.drink.drink.model.Ingredient;
import com.drink.drink.repository.CocktailRepository;
import com.drink.drink.repository.CompositionRepository;
import com.drink.drink.repository.IngredientRepository;
import com.drink.drink.service.IngredientService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Log4j2
@Service
public class IngredientServiceImpl implements IngredientService {

    @Autowired
    IngredientRepository ingredientRepository;

    @Autowired
    CompositionRepository compositionRepository;

    @Autowired
    CocktailRepository cocktailRepository;

    /**
     * Get all ingredient
     * @return List ingredient
     */
    @Override
    public List<IngredientDto> getAll() {
        List<IngredientDto> ingredientDtoList = ingredientRepository.findAll().stream().map(IngredientDto::of).collect(Collectors.toList());
        if (ingredientDtoList.isEmpty()) {
            log.error("Ingredient list is empty. Class IngredientServiceImpl, method getAll");
            throw new NotFoundException("Ingredient list is empty");
        }
        log.info("Get all ingredient. Class IngredientServiceImpl, method getAll");
        return ingredientDtoList;
    }

    /**
     * Get ingredient by id
     * @param id
     * @return Ingredient
     */
    @Override
    public IngredientDto getIngredient(int id) {
        Optional<Ingredient> ingredient = ingredientRepository.findById(id);
        if (!ingredient.isPresent()) {
            log.error("Ingredient not found by id. Class IngredientServiceImpl, method getIngredient");
            throw new NotFoundException("Ingredient not found by id");
        }
        log.info("Get ingredient by id. Class IngredientServiceImpl, method getIngredient");
        return IngredientDto.of(ingredient.get());
    }

    /**
     * Save ingredient
     * @param ingredientDtoCreate
     */
    @Override
    @Transactional
    public void save(IngredientDtoCreate ingredientDtoCreate) {

        Ingredient ingredient = new Ingredient();
        ingredient.setName(ingredientDtoCreate.getName());
        List<Composition> compositionList = compositionRepository.findAllById(ingredientDtoCreate.getCompositionList());
        if (compositionList.isEmpty()) {
            throw new NotFoundException("Add correct composition list");
        }
        ingredient.setCompositionList(compositionList);
        ingredientRepository.save(ingredient);
        log.info("Save ingredient. Class IngredientServiceImpl, method save");

    }

    /**
     * Update Ingredient
     * @param id
     * @param ingredientDtoCreate
     *
     * Если пришел пустой composition то мы тоже должны апдейтить
     */
    @Override
    @Transactional
    public void update(int id, IngredientDtoCreate ingredientDtoCreate) {
        Optional<Ingredient> ingredient = ingredientRepository.findById(id);
        if (!ingredient.isPresent()) {
            log.error("Ingredient not found by id. Class IngredientServiceImpl, method update");
            throw new NotFoundException("Select correct ingredient id");
        }
        List<Composition> compositionList = compositionRepository.findAllById(ingredientDtoCreate.getCompositionList());
        if (compositionList.isEmpty()||compositionList.size()!=ingredientDtoCreate.getCompositionList().size()){
            throw new NotFoundException("Add correct composition list");
        }
        List<Composition> compositionListForIngredient = new ArrayList<>();
        ingredient.get().setName(ingredientDtoCreate.getName());
        for (int i =0; i<compositionList.size();i++){
            Composition composition = new Composition();
            composition.setIngredient(ingredient.get());
            composition.setValue(compositionList.get(i).getValue());
            composition.setUnit(compositionList.get(i).getUnit());
            compositionListForIngredient.add(composition);
        }
        compositionRepository.deleteAll(ingredient.get().getCompositionList());
        ingredient.get().setId(id);
        ingredient.get().setCompositionList(compositionListForIngredient);
        ingredientRepository.save(ingredient.get());
        log.info("Update ingredient. Class IngredientServiceImpl, method update");
    }

    /**
     * Delete Ingredient
     * @param id
     */
    public void delete(int id) {
        Optional<Ingredient> ingredient = ingredientRepository.findById(id);
        if (!ingredient.isPresent()) {
            log.error("Ingredient not found by id. Class IngredientServiceImpl, method delete");
            throw new NotFoundException("Select correct ingredient id");
        }
        ingredientRepository.delete(ingredient.get());
        log.info("Delete ingredient. Class IngredientServiceImpl, method delete");
    }
}
