package com.drink.drink.service;

import com.drink.drink.dto.ricept.RiceptDto;
import com.drink.drink.dto.ricept.RiceptDtoCreate;

import java.util.List;

public interface RiceptService {

    List<RiceptDto> getAll();

    RiceptDto getRicept(int id);

    void save(RiceptDtoCreate riceptDtoCreate);

    void update(int id, RiceptDtoCreate riceptDtoCreate);

    void delete(int id);
}
