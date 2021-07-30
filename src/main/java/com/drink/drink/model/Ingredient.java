package com.drink.drink.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Класс который отвечает за взаимодействие с БД
 * а так же создает таблицу ingredients
 *
 * @author Алексей Моисейчев
 * @author Иван Вязовкин
 */
@Entity
@Table(name = "ingredients")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
/**
 * Class Ingredient
 */
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Size(min= 2, max=64, message = "Name should be between 2-64 characters")
    @NotEmpty(message = "Name should be empty")
    private String name;
    /**
     * Связь многие к одному
     * со стороны БД хранит в себе имя ID
     * со стороны Java берет id у cocktail и дает название cocktail_id
     */
    //@ManyToMany(fetch = FetchType.LAZY ,mappedBy = "ingredientList", cascade = CascadeType.ALL)
    @ManyToMany(mappedBy = "ingredientList")
    private List<Cocktail> cocktailList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "ingredient", cascade = CascadeType.ALL)
    private List<Composition> compositionList;
}
