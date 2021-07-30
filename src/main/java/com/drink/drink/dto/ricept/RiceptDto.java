package com.drink.drink.dto.ricept;

import com.drink.drink.model.Cocktail;
import com.drink.drink.model.Ricept;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

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
 * Class RiceptDto
 */
public class RiceptDto {

    private String description;
    private int orderRicept;

    /**
     * Ricept to RiceptDto
     * @param ricept
     * @return RiceptDto
     */
    public static RiceptDto of(Ricept ricept) {
        RiceptDto riceptDto = new RiceptDto();
        riceptDto.setDescription(ricept.getDescription());
        riceptDto.setOrderRicept(ricept.getOrderRicept());
        log.info("Ricept to RiceptDto.  Class RiceptDto, method of");
        return riceptDto;
    }
}
