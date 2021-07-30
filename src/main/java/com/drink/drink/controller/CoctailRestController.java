package com.drink.drink.controller;

import com.drink.drink.dto.Cocktail.CocktailDtoCreate;
import com.drink.drink.dto.Cocktail.CocktailDtoForGetAll;
import com.drink.drink.dto.Cocktail.CocktailDtoForGetCocktail;
import com.drink.drink.service.CocktailService;
import io.swagger.annotations.Api;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Log4j2
@RestController
@RequestMapping("/cocktails")
@Api(tags = "/api/cocktails")
public class CoctailRestController {

    @Autowired
    CocktailService cocktailService;

    @GetMapping()
    public List<CocktailDtoForGetAll> index() {
        return  cocktailService.getAll();
    }

    /**
     * В этом методе есть вопрос что именно использовать
     *
     * @param id
     * @return
     * @PathVariable("id") работает на переход со страницы
     * @RequestParam("id) работает только в сваггере
     */
    @GetMapping("/{id}")
    public CocktailDtoForGetCocktail show(@PathVariable("id") int id) {
        return cocktailService.getCocktail(id);
    }

    @PostMapping()
    public void create(@RequestBody @Valid CocktailDtoCreate cocktailDtoCreate) {
        cocktailService.save(cocktailDtoCreate);
    }

    @PatchMapping("/{id}")
    public void update(@PathVariable("id") int id, @RequestBody @Valid CocktailDtoCreate cocktailDtoCreate) {
        cocktailService.update(id, cocktailDtoCreate);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) {
        cocktailService.delete(id);
    }
}
