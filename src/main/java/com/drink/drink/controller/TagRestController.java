package com.drink.drink.controller;

import com.drink.drink.dto.tag.TagDto;
import com.drink.drink.dto.tag.TagDtoCreate;
import com.drink.drink.service.TagService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/tags")
@Api(tags = "/api/tags")
public class TagRestController {

    @Autowired
    TagService tagService;

    @GetMapping("/{id}")
    public TagDto show(@PathVariable("id") int id) {
        return tagService.getTag(id);
    }

    @GetMapping
    public List<TagDto> index() {
        return tagService.getAll();
    }

    @PostMapping
    public void create(@RequestBody @Valid TagDtoCreate tagDtoCreate) {
        tagService.save(tagDtoCreate);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody @Valid TagDtoCreate tagDtoCreate,
                       @PathVariable("id") int id) {
        tagService.update(id, tagDtoCreate);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) {
        tagService.delete(id);
    }
}
