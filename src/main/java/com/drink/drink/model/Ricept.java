package com.drink.drink.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * Класс который отвечает за взаимодействие с БД
 * а так же создает таблицу ricepts
 *
 * @author Алексей Моисейчев
 * @author Иван Вязовкин
 */
@Entity
@Table(name = "ricepts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
/**
 * Class Ricept
 */
public class Ricept {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String description;
    @Column(name = "order_ricept")
    private int orderRicept;
    /**
     * Связь многие к одному
     * со стороны БД хранит в себе имя ID
     * со стороны Java берет id у cocktail и дает название cocktail_id
     */
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "cocktail_id")
    private Cocktail cocktail;
}


