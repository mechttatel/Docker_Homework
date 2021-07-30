package com.drink.drink.service.impl;

import com.drink.drink.dto.ricept.RiceptDto;
import com.drink.drink.dto.ricept.RiceptDtoCreate;
import com.drink.drink.exception.NotFoundException;
import com.drink.drink.model.Cocktail;
import com.drink.drink.model.Ricept;
import com.drink.drink.repository.CocktailRepository;
import com.drink.drink.repository.RiceptRepository;
import com.drink.drink.service.CocktailService;
import com.drink.drink.service.RiceptService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Log4j2
@Service
public class RiceptServiceImpl implements RiceptService {

    @Autowired
    RiceptRepository riceptRepository;

    @Autowired
    CocktailRepository cocktailRepository;

    @Autowired
    CocktailService cocktailService;

    @Override
    public List<RiceptDto> getAll() {
        List<RiceptDto> riceptDtoList = riceptRepository.findAll().stream().map(RiceptDto::of).collect(Collectors.toList());
        if (riceptDtoList.isEmpty()){
            throw new NotFoundException("Ricept list is empty");
        }
        return riceptDtoList;
    }

    /**
     * Get Ricept by id
     * @param id
     * @return
     */
    @Override
    public RiceptDto getRicept(int id) {
        Optional<Ricept> ricept = riceptRepository.findById(id);
        if (!ricept.isPresent()) {
            log.error("Ricept not found by id. Class RiceptServiceImpl, method getRicept");
            throw new NotFoundException("Ricept not found by id");
        }
        log.info("Get ingredient by id. Class RiceptServiceImpl, method getRicept");
        return RiceptDto.of(ricept.get());
    }

    /**
     * Save Ricept
     * @param riceptDtoCreate
     */
    @Override
    public void save(RiceptDtoCreate riceptDtoCreate) {
        riceptRepository.save(RiceptDtoCreate.of(riceptDtoCreate));
        log.info("Save ingredient. Class RiceptServiceImpl, method save");
    }

    /**
     * Update Ricept
     * @param id
     * @param riceptDtoCreate
     */
    @Override
    public void update(int id, RiceptDtoCreate riceptDtoCreate) {
        Optional<Ricept> riceptOptional = riceptRepository.findById(id);
        if (!riceptOptional.isPresent()) {
            log.error("Ricept not found by id. Class RiceptServiceImpl, method update");
            throw new NotFoundException("Ricept not found by id");
        }
        riceptOptional.get().setOrderRicept(riceptDtoCreate.getOrderRicept());
        riceptOptional.get().setDescription(riceptDtoCreate.getDescription());

        riceptOptional.get().setId(id);
        riceptRepository.save(riceptOptional.get());
        log.info("Update ingredient. Class RiceptServiceImpl, method update");
    }

    /**
     * Delete Ricept
     * @param id
     */
    @Override
    public void delete(int id) {
        Optional<Ricept> ricept = riceptRepository.findById(id);
        if (!ricept.isPresent()) {
            log.error("Ricept not found by id. Class RiceptServiceImpl, method delete");
            throw new NotFoundException("Ricept not found by id");
        }
        riceptRepository.delete(ricept.get());
        log.info("Delete ingredient. Class RiceptServiceImpl, method delete");
    }
}
/*        Optional<Cocktail> cocktailOptional = cocktailRepository.findById(riceptDtoCreate.getCocktailId());
        if (!cocktailOptional.isPresent()) {
            log.error("Cocktail not found by id. Class RiceptServiceImpl, method update");
            throw new NotFoundException("Add correct cocktail");
        }
        riceptOptional.get().setCocktail(cocktailOptional.get());*/






/*        Optional<Cocktail> cocktailOptional = cocktailRepository.findById(riceptDtoCreate.getCocktailId());
        if (!cocktailOptional.isPresent()){
            throw new NotFoundException("Add correct cocktail");
        }*/
