package com.drink.drink.dto.Cocktail;

import com.drink.drink.dto.tag.TagDto;
import com.drink.drink.model.Cocktail;
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
@AllArgsConstructor
@NoArgsConstructor
/**
 * Class CocktailDtoForGetAll
 */
public class CocktailDtoForGetAll {

    private int id;
    private String name;
    private String photoUrl;
    private int alcohol;
    private String comment;
    private List<String> tagDtoList;

    /**
     * Cocktail to CocktailDtoForGetAll
     * @param cocktail
     * @return CocktailDtoForGetAll
     */
    public static CocktailDtoForGetAll of(Cocktail cocktail) {

        CocktailDtoForGetAll cocktailDtoForGetAll = new CocktailDtoForGetAll();
        cocktailDtoForGetAll.setId(cocktail.getId());
        cocktailDtoForGetAll.setComment(cocktail.getComment());
        cocktailDtoForGetAll.setTagDtoList(cocktail.getTagList().stream().map(x -> TagDto.of(x).getName()).collect(Collectors.toList()));
        cocktailDtoForGetAll.setAlcohol(cocktail.getAlcohol());
        cocktailDtoForGetAll.setName(cocktail.getName());
        cocktailDtoForGetAll.setPhotoUrl(cocktail.getPhotoUrl());
        log.info("Cocktail to CocktailDtoForGetAll.  Class CocktailDtoForGetAll, method of");
        return cocktailDtoForGetAll;
    }
}
