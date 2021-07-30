package com.drink.drink.service.impl;

import com.drink.drink.dto.Cocktail.CocktailDtoCreate;
import com.drink.drink.dto.Cocktail.CocktailDtoForGetAll;
import com.drink.drink.dto.Cocktail.CocktailDtoForGetCocktail;
import com.drink.drink.exception.ListIsEmptyException;
import com.drink.drink.exception.NotFoundException;
import com.drink.drink.model.Cocktail;
import com.drink.drink.model.Ingredient;
import com.drink.drink.model.Ricept;
import com.drink.drink.model.Tag;
import com.drink.drink.repository.CocktailRepository;
import com.drink.drink.repository.IngredientRepository;
import com.drink.drink.repository.RiceptRepository;
import com.drink.drink.repository.TagRepository;
import com.drink.drink.service.CocktailService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
/**
 * Сервис который отвечает за бизнес-логику и обрабатывает запросы по cocktail
 *
 * @author Алексей Моисейчев
 * @author Иван Вязовкин
 */

/**
 * Помечает класс что он является service можно заменить на @component
 */
@Log4j2
@Service
public class CocktailServiceImpl implements CocktailService {

    @Autowired
    CocktailRepository cocktailRepository;

    @Autowired
    IngredientRepository ingredientRepository;

    @Autowired
    RiceptRepository riceptRepository;

    @Autowired
    TagRepository tagRepository;

    /**
     * Delete coctail by id
     * @param id
     */

    @Override
    public void delete(int id) {
        Optional<Cocktail> cocktailOptional = cocktailRepository.findById(id);
        if (!cocktailOptional.isPresent()) {
            log.error("Cocktail not found by id. Class CocktailServiceImpl, method delete");
            throw new NotFoundException("Cocktail not found by id");
        }
        cocktailRepository.delete(cocktailOptional.get());
        log.info("Delete coctail.  Class CocktailServiceImpl, method delete");
    }

    /**
     * Update coctail by id
     * @param id
     * @param cocktailDtoCreate
     */
    @Override
    @Transactional
    public void update(int id, CocktailDtoCreate cocktailDtoCreate) {
        Optional<Cocktail> cocktailOptional = cocktailRepository.findById(id);
        if (!cocktailOptional.isPresent()) {
            log.error("Cocktail not found by id. Class CocktailServiceImpl, method update");
            throw new NotFoundException("Cocktail not found by id");
        }

        cocktailOptional.get().setName(cocktailDtoCreate.getName());
        cocktailOptional.get().setComment(cocktailDtoCreate.getComment());
        cocktailOptional.get().setAlcohol(cocktailDtoCreate.getAlcohol());
        cocktailOptional.get().setPhotoUrl(cocktailDtoCreate.getPhotoUrl());
        List<Ingredient> ingredientList = ingredientRepository.findAllById(cocktailDtoCreate.getIngredientList());
        if (ingredientList.isEmpty() || ingredientList.size() != cocktailDtoCreate.getIngredientList().size()) {
            throw new NotFoundException("Add correct ingredient list");
        }
        cocktailOptional.get().setIngredientList(ingredientList);

        List<Tag> tagList = tagRepository.findAllById(cocktailDtoCreate.getTagList());
        if (tagList.isEmpty() || tagList.size() != cocktailDtoCreate.getTagList().size()) {
            throw new NotFoundException("Add correct tag list");
        }
        cocktailOptional.get().setTagList(tagList);
        List<Ricept> riceptList = riceptRepository.findAllById(cocktailDtoCreate.getRiceptList());
        if (riceptList.isEmpty() || riceptList.size() != cocktailDtoCreate.getRiceptList().size()) {
            throw new NotFoundException("Add correct ricept list");
        }
        int count = 1;
        List<Ricept> riceptListNew = new ArrayList<>();
        for (int i = 0; i < riceptList.size(); i++) {

            Ricept ricept = new Ricept();
            ricept.setCocktail(cocktailOptional.get());
            ricept.setDescription(riceptList.get(i).getDescription());
            ricept.setOrderRicept(count++);
            riceptListNew.add(ricept);
        }
        riceptRepository.deleteAll(cocktailOptional.get().getRiceptList());

        cocktailOptional.get().setId(id);
        cocktailOptional.get().setRiceptList(riceptListNew);

        cocktailRepository.save(cocktailOptional.get());
        log.info("Update coctail Class. CocktailServiceImpl, method update");
    }


    /**
     * Save coctail
     * @param cocktailDtoCreate
     */
    @Transactional
    public void save(CocktailDtoCreate cocktailDtoCreate) {

        Cocktail cocktail = CocktailDtoCreate.of(cocktailDtoCreate);

        List<Ingredient> ingredientList = ingredientRepository.findAllById(cocktailDtoCreate.getIngredientList());
        if (ingredientList.isEmpty() || ingredientList.size() != cocktailDtoCreate.getIngredientList().size()) {
            throw new NotFoundException("Add correct ingredient list");
        }
        cocktail.setIngredientList(ingredientList);

        List<Tag> tagList = tagRepository.findAllById(cocktailDtoCreate.getTagList());
        if (tagList.isEmpty() || tagList.size() != cocktailDtoCreate.getTagList().size()) {
            throw new NotFoundException("Add correct tag list");
        }
        cocktail.setTagList(tagList);
        List<Ricept> riceptList = riceptRepository.findAllById(cocktailDtoCreate.getRiceptList());
        if (riceptList.isEmpty() || riceptList.size() != cocktailDtoCreate.getRiceptList().size()) {
            throw new NotFoundException("Add correct ricept list");
        }

        int count = 1;
        List<Ricept> riceptListNew = new ArrayList<>();
        for (int i = 0; i < riceptList.size(); i++) {

            Ricept ricept = new Ricept();
            ricept.setCocktail(cocktail);
            ricept.setDescription(riceptList.get(i).getDescription());
            ricept.setOrderRicept(count++);
            riceptListNew.add(ricept);
        }
        cocktail.setRiceptList(riceptListNew);
        //cocktail.setTagList(tagRepository.findAllById(cocktailDtoCreate.getTagList()));
        cocktailRepository.save(cocktail);
        log.info("Save coctail. Class CocktailServiceImpl, method save");
    }


    /**
     * Get all cocktail
     * @return List coctails
     */

    @Override
    public List<CocktailDtoForGetAll> getAll() {
        List<CocktailDtoForGetAll> cocktailDtoForGetAllList = cocktailRepository.findAll()
                .stream()
                .map(CocktailDtoForGetAll::of)
                .collect(Collectors.toList());
        if (cocktailDtoForGetAllList.isEmpty()) {
            log.error("Cocktail list is empty. Class CocktailServiceImpl, method getAll");
            throw new ListIsEmptyException("Cocktail list is empty");
        }
        log.info("Get all cocktail. Class CocktailServiceImpl, method getCocktail");
        return cocktailDtoForGetAllList;
    }

    /**
     * Get coctail by id
     * @param id
     * @return
     */

    @Transactional
    @Override
    public CocktailDtoForGetCocktail getCocktail(int id) {
        Optional<Cocktail> cocktail = cocktailRepository.findById(id);
        if (!cocktail.isPresent()) {
            log.error("Cocktail not found by id. Class CocktailServiceImpl, method getCocktail");
            throw new NotFoundException("Cocktail not found by id");
        }
        log.info("Return cocktail find by id. Class CocktailServiceImpl, method getCocktail");
        return CocktailDtoForGetCocktail.of(cocktail.get());
    }
}
