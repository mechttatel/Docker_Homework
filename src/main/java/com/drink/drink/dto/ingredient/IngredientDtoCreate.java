package com.drink.drink.dto.ingredient;

import com.drink.drink.dto.composition.CompositionDtoCreate;
import com.drink.drink.model.Ingredient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
/**
 * Class IngredientDtoCreate
 */
public class IngredientDtoCreate {
    @Size(min= 2, max=64)
    @NotEmpty(message = "Name should be empty")
    private String name;
    private List<Integer> compositionList;
    //private List<Integer> cocktailList;

    /**
     * IngredientDtoCreate to Ingredient
     * @param ingredientDtoCreate
     * @return Ingredient
     */
    public static Ingredient of(IngredientDtoCreate ingredientDtoCreate) {
        Ingredient ingredient = new Ingredient();
        ingredient.setName(ingredientDtoCreate.getName());
        log.info("IngredientDtoCreate to Ingredient.  Class IngredientDtoCreate, method of");


        return ingredient;
    }

}
//private List<Integer> cocktailList;

/*        ingredient.setCompositionList(ingredientDtoCreate.getCompositionDtoCreateList()
                .stream()
                .map(CompositionDtoCreate::of)
                .collect(Collectors.toList()));*/