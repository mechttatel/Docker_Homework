package com.drink.drink.controller;

import com.drink.drink.dto.composition.CompositionDto;
import com.drink.drink.dto.composition.CompositionDtoCreate;
import com.drink.drink.service.CompositionService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/compositions")
@Api(tags = "/api/compositions")
public class CompositionRestController {

    @Autowired
    CompositionService compositionService;

    @GetMapping("/{id}")
    public CompositionDto show(@PathVariable("id") int id) {
        return compositionService.getComposition(id);
    }

    @GetMapping
    public List<CompositionDto> index() {
        return compositionService.getAll();
    }

    @PostMapping
    public void create(@RequestBody @Valid CompositionDtoCreate compositionDtoCreate) {
        compositionService.save(compositionDtoCreate);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody @Valid CompositionDtoCreate compositionDtoCreate,
                       @PathVariable("id") int id) {
        compositionService.update(id, compositionDtoCreate);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) {
        compositionService.delete(id);
    }
}
