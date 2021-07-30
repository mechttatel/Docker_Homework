package com.drink.drink.service;

import com.drink.drink.dto.ingredient.IngredientDto;
import com.drink.drink.dto.ingredient.IngredientDtoCreate;
import com.drink.drink.model.Ingredient;

import java.util.List;

public interface IngredientService {

    List<IngredientDto> getAll();

    IngredientDto getIngredient(int id);

    void save(IngredientDtoCreate ingredientDtoCreate);

    void update(int id, IngredientDtoCreate ingredientDtoCreate);

    void delete(int id);
}
