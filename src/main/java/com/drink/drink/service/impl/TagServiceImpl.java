package com.drink.drink.service.impl;

import com.drink.drink.dto.tag.TagDto;
import com.drink.drink.dto.tag.TagDtoCreate;
import com.drink.drink.exception.ListIsEmptyException;
import com.drink.drink.exception.NotFoundException;
import com.drink.drink.model.Cocktail;
import com.drink.drink.model.Tag;
import com.drink.drink.repository.CocktailRepository;
import com.drink.drink.repository.TagRepository;
import com.drink.drink.service.TagService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Log4j2
@Service
public class TagServiceImpl implements TagService {

    @Autowired
    TagRepository tagRepository;

    @Autowired
    CocktailRepository cocktailRepository;

    /**
     * Get all Tags
     * @return
     */
    @Override
    public List<TagDto> getAll() {
        List<TagDto> tagDtoList = tagRepository.findAll()
                .stream()
                .map(TagDto::of)
                .collect(Collectors.toList());
        if (tagDtoList.isEmpty()){
            throw new ListIsEmptyException("Tag list is empty");
        }
        log.info("Get tags. Class TagServiceImpl, method getAll");
        return tagDtoList;
    }

    /**
     * Get tag by id
     * @param id
     * @return
     */
    @Override
    public TagDto getTag(int id) {
        Optional<Tag> tag = tagRepository.findById(id);
        if (!tag.isPresent()) {
            log.error("Tag not found by id. Class TagServiceImpl, method getTag");
            throw new NotFoundException("Tag not found by id");
        }
        log.info("Get tag by id. Class TagServiceImpl, method getTag");
        return TagDto.of(tag.get());
    }

    /**
     * Save Tag
     * @param tagDtoCreate
     */
    @Override
    public void save(TagDtoCreate tagDtoCreate) {
        tagRepository.save(TagDtoCreate.of(tagDtoCreate));
        log.info("Save tag. Class TagServiceImpl, method save");
    }

    /**
     * Update Tag
     * @param id
     * @param tagDtoCreate
     */
    @Override
    public void update(int id, TagDtoCreate tagDtoCreate) {
        Optional<Tag> tagOptional = tagRepository.findById(id);
        if (!tagOptional.isPresent()) {
            log.error("Tag not found by id. Class TagServiceImpl, method update");
            throw new NotFoundException("Tag not found by id");
        }
        tagOptional.get().setName(tagDtoCreate.getName());
        tagOptional.get().setId(id);

        tagRepository.save(tagOptional.get());
        log.info("Update tag. Class TagServiceImpl, method update");
    }

    /**
     * Delete Tag
     * @param id
     */
    @Override
    public void delete(int id) {
        Optional<Tag> tag = tagRepository.findById(id);
        if (!tag.isPresent()) {
            log.error("Tag not found by id. Class TagServiceImpl, method delete");
            throw new NotFoundException("Tag not found by id");
        }
        tagRepository.delete(tag.get());
        log.info("Delete tag. Class TagServiceImpl, method delete");

    }
}


/*        List<Cocktail> cocktailList = cocktailRepository.findAllById(tagDtoCreate.getCocktailList());
        if (cocktailList.isEmpty()|| cocktailList.size()!=tagDtoCreate.getCocktailList().size()){
            throw new NotFoundException("Add correct cocktail");
        }
        tagOptional.get().setCocktailList(cocktailList);*/
