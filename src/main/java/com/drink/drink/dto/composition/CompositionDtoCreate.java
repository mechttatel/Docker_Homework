package com.drink.drink.dto.composition;

import com.drink.drink.model.Composition;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Log4j2
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
/**
 * Class CompositionDtoCreate
 */
public class CompositionDtoCreate {

    @NotNull(message = "value should be empty")
    private int value;
    @Size(min= 2, max=64)
    @NotEmpty(message = "unit should be empty")
    private String unit;
    @NotNull(message = "Ingredient Id should be empty")
    private int ingredientId;

    /**
     * CompositionDtoCreate to Composition
     *
     * @param compositionDtoCreate
     * @return Composition
     */
    public static Composition of(CompositionDtoCreate compositionDtoCreate) {

        Composition composition = new Composition();
        composition.setUnit(compositionDtoCreate.getUnit());
        composition.setValue(compositionDtoCreate.getValue());
        log.info("CompositionDtoCreate to Composition.  Class CompositionDtoCreate, method of");
        return composition;
    }

}
