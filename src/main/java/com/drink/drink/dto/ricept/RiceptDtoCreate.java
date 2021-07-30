package com.drink.drink.dto.ricept;

import com.drink.drink.model.Ricept;
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
 * Class RiceptDtoCreate
 */
public class RiceptDtoCreate {

    @Size(min= 2)
    @NotEmpty(message = "Description should be empty")
    private String description;
    @NotNull(message = "Ricept id should be empty")
    private int orderRicept;
    //@NotNull(message = "Cocktail id should be empty")
    //private int cocktailId;

    /**
     * RiceptDtoCreate to Ricept
     * @param riceptDtoCreate
     * @return Ricept
     */
    public static Ricept of(RiceptDtoCreate riceptDtoCreate) {
        Ricept ricept = new Ricept();
        ricept.setDescription(riceptDtoCreate.getDescription());
        ricept.setOrderRicept(riceptDtoCreate.getOrderRicept());
        log.info("RiceptDtoCreate to Ricept.  Class RiceptDtoCreate, method of");
        return ricept;
    }

}
