package com.drink.drink.repository;

import com.drink.drink.model.Ricept;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RiceptRepository extends JpaRepository<Ricept, Integer> {
}
