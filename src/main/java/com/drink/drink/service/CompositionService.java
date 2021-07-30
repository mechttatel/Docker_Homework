package com.drink.drink.service;

import com.drink.drink.dto.composition.CompositionDto;
import com.drink.drink.dto.composition.CompositionDtoCreate;

import java.util.List;

public interface CompositionService {

    CompositionDto getComposition(int id);

    List<CompositionDto> getAll();

    void save(CompositionDtoCreate compositionDtoCreate);

    void update(int id, CompositionDtoCreate compositionDtoCreate);

    void delete(int id);

}
