package com.drink.drink.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
/**
 Класс который отвечает за взаимодействие с БД
 а так же создает таблицу tags


 * @author Алексей Моисейчев
 * @author Иван Вязовкин
 */
@Entity
@Table(name = "tags")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
/**
 * Class Tag
 */
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    /**
     * Свзяь многие ко многим. Многие ко многим должны иметь виртуальную таблицу
     * со стороны Java она должна быть написана либо tags либо у cocktails
     * в данном примере описание таблицы реализовано со стороны cocktails
     * (mappedBy = "tagList") - указывает на то с каким списком связанна
     * из сущности/таблицы tags
     * List<Cocktail> cocktailsList - хранит список фильмов
     */
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "tagList", cascade = CascadeType.ALL)
    private List<Cocktail> cocktailList;
}
