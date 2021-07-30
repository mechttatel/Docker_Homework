package com.drink.drink.service.impl;

import com.drink.drink.dto.composition.CompositionDto;
import com.drink.drink.dto.composition.CompositionDtoCreate;
import com.drink.drink.exception.NotFoundException;
import com.drink.drink.model.Composition;
import com.drink.drink.model.Ingredient;
import com.drink.drink.repository.CompositionRepository;
import com.drink.drink.repository.IngredientRepository;
import com.drink.drink.service.CompositionService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Log4j2
@Service
public class CompositionServiceImpl implements CompositionService {

    @Autowired
    CompositionRepository compositionRepository;
    @Autowired
    IngredientRepository ingredientRepository;

    /**
     * Get composition by id
     * @param id
     * @return CompositionDto
     */

    @Override
    public CompositionDto getComposition(int id) {
        Optional<Composition> composition = compositionRepository.findById(id);
        if (!composition.isPresent()) {
            log.error("Composition not found by id. Class CompositionServiceImpl method getComposition");
            throw new NotFoundException("Composition not found by id");
        }
        log.info("Return composition find by id. Class CompositionServiceImpl, method getComposition");
        return CompositionDto.of(composition.get());
    }

    /**
     * Get all CompositionDto
     * @return
     */

    @Override
    public List<CompositionDto> getAll() {
        List<CompositionDto> compositionDtoList = compositionRepository.findAll().stream().map(CompositionDto::of).collect(Collectors.toList());
        if (compositionDtoList.isEmpty()){
            throw new NotFoundException("Composition list is empty");
        }
        log.info("Get all composition. Class CompositionServiceImpl, method getAll");
        return compositionDtoList;
    }

    /**
     * Save Composition
     * @param compositionDtoCreate
     */

    @Override
    public void save(CompositionDtoCreate compositionDtoCreate) {
        Optional<Ingredient> ingredient = ingredientRepository.findById(compositionDtoCreate.getIngredientId());
        if (!ingredient.isPresent()){
            log.error("ingredient not found by id. Class CompositionServiceImpl method save");
            throw new NotFoundException("ingredient not found by id");
        }
        Composition composition = CompositionDtoCreate.of(compositionDtoCreate);
        composition.setIngredient(ingredient.get());

        compositionRepository.save(composition);
        log.info("Save composition. Class CompositionServiceImpl, method save");
    }

    /**
     * Update Composition
     * @param id
     * @param compositionDtoCreate
     */

    @Override
    public void update(int id, CompositionDtoCreate compositionDtoCreate) {

        Optional<Composition> composition = compositionRepository.findById(id);
        if(!composition.isPresent()){
            log.error("Composition not found by id. Class CompositionServiceImpl method update");
            throw new NotFoundException("Composition not found by id");
        }
        Optional<Ingredient> ingredient = ingredientRepository.findById(compositionDtoCreate.getIngredientId());
        if (!ingredient.isPresent()){
            log.error("Ingredient not found by id. Class CompositionServiceImpl method update");
            throw new NotFoundException("ingredient not found by id");
        }

        composition.get().setId(id);
        composition.get().setUnit(compositionDtoCreate.getUnit());
        composition.get().setValue(compositionDtoCreate.getValue());
        composition.get().setIngredient(ingredient.get());

        compositionRepository.save(composition.get());
        log.info("Update composition. Class CompositionServiceImpl, method update");

    }

    /**
     * Delete Composition by id
     * @param id
     */

    @Override
    public void delete(int id) {
        Optional<Composition> composition = compositionRepository.findById(id);
        if (!composition.isPresent()) {
            log.error("Composition not found by id. Class CompositionServiceImpl method delete");
            throw new NotFoundException("Composition not found by id");
        }
        compositionRepository.delete(composition.get());
        log.info("Delete composition. Class CompositionServiceImpl, method delete");
    }
}


/*        Optional<Ingredient> ingredient = ingredientRepository.findById(compositionDtoCreate.getIngredientId());
        if (!ingredient.isPresent()){
            log.error("ingredient not found by id. Class CompositionServiceImpl method save");
            throw new NotFoundException("ingredient not found by id");
        }
        Composition composition = CompositionDtoCreate.of(compositionDtoCreate);
        composition.setIngredient(ingredient.get());

        compositionRepository.save(composition);*/