package com.drink.drink.controller;

import com.drink.drink.dto.ingredient.IngredientDto;
import com.drink.drink.dto.ingredient.IngredientDtoCreate;
import com.drink.drink.service.IngredientService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/ingredients")
@Api(tags = "/api/ingredients")
public class IngredientRestController {

    @Autowired
    IngredientService ingredientService;

    @GetMapping("/{id}")
    public IngredientDto show(@PathVariable("id") int id) {
        return ingredientService.getIngredient(id);
    }

    @GetMapping()
    public List<IngredientDto> index() {
        return ingredientService.getAll();
    }

    @PostMapping
    public void create(@RequestBody @Valid IngredientDtoCreate ingredientDtoCreate) {
        ingredientService.save(ingredientDtoCreate);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") int id,
                       @RequestBody @Valid IngredientDtoCreate ingredientDtoCreate) {
        ingredientService.update(id, ingredientDtoCreate);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) {
        ingredientService.delete(id);
    }
}
