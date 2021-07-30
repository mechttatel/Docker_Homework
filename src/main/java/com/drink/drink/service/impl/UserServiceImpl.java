package com.drink.drink.service.impl;

import com.drink.drink.config.security.JwtProvider;
import com.drink.drink.exception.NotFoundException;
import com.drink.drink.model.UserEntity;
import com.drink.drink.repository.UserRepository;
import com.drink.drink.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;

    @Override
    public String generateToken(String email, String password) {
        UserEntity userEntity = userRepository.findByEmail(email)
                .orElseThrow(() -> new NotFoundException("User not found"));
        if (passwordEncoder.matches(password, userEntity.getPassword())) {
            return jwtProvider.generateToken(userEntity.getEmail());
        } else {
            throw new NotFoundException("User not active");
        }
    }

    @Override
    public Optional<UserEntity> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
