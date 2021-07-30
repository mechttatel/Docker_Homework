package com.drink.drink.service;

import com.drink.drink.model.UserEntity;

import java.util.Optional;

public interface UserService {

    String generateToken(String email, String password);

    Optional<UserEntity> findByEmail(String email);
}
