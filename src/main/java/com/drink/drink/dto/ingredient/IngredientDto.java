package com.drink.drink.dto.ingredient;

import com.drink.drink.dto.composition.CompositionDto;
import com.drink.drink.model.Ingredient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс который отвечает за переопределение инфы из бд в инфу java
 *
 * @author Алексей Моисейчев
 * @author Иван Вязовкин
 */
@Log4j2
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
/**
 * Class IngredientDto
 */
public class IngredientDto {

    private String name;
    private List<CompositionDto> compositionDtoList;

    /**
     * Ingredient to IngredientDto
     * @param ingredient
     * @return IngredientDto
     */
    public static IngredientDto of(Ingredient ingredient) {

        IngredientDto ingredientDto = new IngredientDto();
        ingredientDto.setName(ingredient.getName());
        ingredientDto.setCompositionDtoList(ingredient.getCompositionList()
                .stream()
                .map(CompositionDto::of)
                .collect(Collectors.toList()));
        log.info("Ingredient to IngredientDto.  Class IngredientDto, method of");
        return ingredientDto;

    }
}
