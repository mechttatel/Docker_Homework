package com.drink.drink.dto.composition;

import com.drink.drink.model.Composition;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
/**
 * Class CompositionDto
 */
public class CompositionDto {

    private int value;
    private String unit;

    /**
     * Composition to CompositionDto
     * @param composition
     * @return CompositionDto
     */
    public static CompositionDto of(Composition composition) {
        CompositionDto compositionDto = new CompositionDto();
        compositionDto.setUnit(composition.getUnit());
        compositionDto.setValue(composition.getValue());
        log.info("Composition to CompositionDto.  Class CompositionDto, method of");
        return compositionDto;
    }
}
