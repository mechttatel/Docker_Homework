package com.drink.drink.controller;

import com.drink.drink.dto.ricept.RiceptDto;
import com.drink.drink.dto.ricept.RiceptDtoCreate;
import com.drink.drink.service.RiceptService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/ricepts")
@Api(tags = "/api/ricepts")
public class RiceptRestController {

    @Autowired
    RiceptService riceptService;

    @GetMapping("/{id}")
    public RiceptDto show(@PathVariable ("id") int id){
        return riceptService.getRicept(id);
    }

    @GetMapping
    public List<RiceptDto> index (){
        return riceptService.getAll();
    }

    @PostMapping
    public void create (@RequestBody @Valid RiceptDtoCreate riceptDtoCreate){
        riceptService.save(riceptDtoCreate);
    }

    @PutMapping("/{id}")
    public void update (@PathVariable ("id") int id,
                        @RequestBody @Valid RiceptDtoCreate riceptDtoCreate){
        riceptService.update(id, riceptDtoCreate);
    }

    @DeleteMapping("/{id}")
    public void delete (@PathVariable ("id") int id){
        riceptService.delete(id);
    }

}
