package com.drink.drink.service;

import com.drink.drink.dto.tag.TagDto;
import com.drink.drink.dto.tag.TagDtoCreate;

import java.util.List;

public interface TagService {
    List<TagDto> getAll();

    TagDto getTag(int id);

    void save(TagDtoCreate tagDtoCreate);

    void update(int id, TagDtoCreate tagDtoCreate);

    void delete(int id);
}
