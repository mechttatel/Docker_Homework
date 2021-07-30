package com.drink.drink.dto.Cocktail;

import com.drink.drink.model.Cocktail;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

import java.util.List;

@Log4j2
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
/**
 * Class CocktailDto
 */
public class CocktailDto {

    private String name;
    private String photoUrl;
    private int alcohol;
    private String comment;
    private List<Integer> riceptList;
    private List<Integer> ingredientList;
    private List<Integer> tagList;

    /**
     * Cocktail to CocktailDto
     * @param cocktail
     * @return
     */
    public static CocktailDto of (Cocktail cocktail){
        CocktailDto cocktailDto = new CocktailDto();
        cocktailDto.setComment(cocktail.getComment());
        cocktailDto.setAlcohol(cocktail.getAlcohol());
        cocktailDto.setName(cocktail.getName());
        cocktailDto.setPhotoUrl(cocktail.getPhotoUrl());
        log.info("Coctail to CocktailDto.  Class CocktailDto, method of");
        return cocktailDto;
    }
}
