package com.drink.drink.repository;

import com.drink.drink.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {
    //void deleteByCocktail_Id(int id);
}
