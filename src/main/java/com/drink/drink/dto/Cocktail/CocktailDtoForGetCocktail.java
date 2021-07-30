package com.drink.drink.dto.Cocktail;

import com.drink.drink.dto.ingredient.IngredientDto;
import com.drink.drink.dto.ricept.RiceptDto;
import com.drink.drink.dto.tag.TagDto;
import com.drink.drink.model.Cocktail;
import com.drink.drink.model.Ricept;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

import java.util.Comparator;
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
 * Class CocktailDtoForGetCocktail
 */
public class CocktailDtoForGetCocktail {

    private int id;
    private String name;
    private String photoUrl;
    private int alcohol;
    private String comment;
    private List<String> tagDtoList;
    private List<IngredientDto> ingredientDtoList;
    private List<String> riceptDtoList;

    /**
     * Cocktail to CocktailDtoForGetCocktail
     * @param cocktail
     * @return CocktailDtoForGetCocktail
     */

    public static CocktailDtoForGetCocktail of(Cocktail cocktail) {

        CocktailDtoForGetCocktail cocktailDtoForGetCocktail = new CocktailDtoForGetCocktail();
        cocktailDtoForGetCocktail.setId(cocktail.getId());
        cocktailDtoForGetCocktail.setComment(cocktail.getComment());
        cocktailDtoForGetCocktail.setAlcohol(cocktail.getAlcohol());
        cocktailDtoForGetCocktail.setName(cocktail.getName());
        cocktailDtoForGetCocktail.setPhotoUrl(cocktail.getPhotoUrl());

        cocktailDtoForGetCocktail.setTagDtoList(cocktail.getTagList()
                .stream()
                .map(x -> TagDto.of(x).getName())
                .collect(Collectors.toList()));

        cocktailDtoForGetCocktail.setIngredientDtoList(cocktail.getIngredientList()
                .stream()
                .map(IngredientDto::of)
                .collect(Collectors.toList()));

        cocktailDtoForGetCocktail.setRiceptDtoList(cocktail.getRiceptList()
                .stream()
                .sorted(Comparator.comparing(Ricept::getOrderRicept))
                .map(x -> RiceptDto.of(x).getDescription())
                .collect(Collectors.toList()));
        log.info("Cocktail to CocktailDtoForGetCocktail.  Class CocktailDtoForGetCocktail, method of");
        return cocktailDtoForGetCocktail;
    }
}
