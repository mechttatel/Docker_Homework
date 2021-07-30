package com.drink.drink.service;

import com.drink.drink.dto.Cocktail.CocktailDtoCreate;
import com.drink.drink.dto.Cocktail.CocktailDtoForGetAll;
import com.drink.drink.dto.Cocktail.CocktailDtoForGetCocktail;

import java.util.List;

public interface CocktailService {

    List<CocktailDtoForGetAll> getAll();

    CocktailDtoForGetCocktail getCocktail(int id);

    void save(CocktailDtoCreate cocktailDtoCreate);

    void update(int id, CocktailDtoCreate cocktailDtoCreate);

    void delete(int id);
}
