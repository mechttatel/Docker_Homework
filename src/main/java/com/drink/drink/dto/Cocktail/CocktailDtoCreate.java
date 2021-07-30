package com.drink.drink.dto.Cocktail;

import com.drink.drink.model.Cocktail;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.LinkedList;
import java.util.List;

@Log4j2
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
/**
 * Class CocktailDtoCreate
 */
public class CocktailDtoCreate {

    @Size(min = 2, max = 64)
    @NotEmpty(message = "name should be empty")
    private String name;
    private String photoUrl;
    @Size(max = 100)
    @NotNull(message = "alcohol should be empty")
    private int alcohol;
    @Size(min = 2, max = 256)
    @NotEmpty(message = "comment should be empty")
    private String comment;
    private List<Integer> riceptList;
    private List<Integer> ingredientList;
    private List<Integer> tagList;

    /**
     * CocktailDtoCreate to Cocktail
     *
     * @param cocktailDtoCreate
     * @return Cocktail
     */
    public static Cocktail of(CocktailDtoCreate cocktailDtoCreate) {
        Cocktail cocktail = new Cocktail();
        cocktail.setComment(cocktailDtoCreate.getComment());
        cocktail.setAlcohol(cocktailDtoCreate.getAlcohol());
        cocktail.setName(cocktailDtoCreate.getName());
        cocktail.setPhotoUrl(cocktailDtoCreate.getPhotoUrl());
        List<Cocktail> list = new LinkedList<>();
        list.get(12);

        log.info("CocktailDtoCreate to Cocktail.  Class CocktailDtoCreate, method of");
        return cocktail;


    }
}
