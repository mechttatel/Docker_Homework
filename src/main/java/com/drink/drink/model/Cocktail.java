package com.drink.drink.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

/**
 * Класс который отвечает за взаимодействие с БД
 * а так же создает таблицу cocktails
 *
 * @author Алексей Моисейчев
 * @author Иван Вязовкин
 */
@Entity
@Table(name = "cocktails")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
/**
 * Class Cocktail
 */
public class Cocktail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Column(name = "photo_url")
    private String photoUrl;
    private int alcohol;
    private String comment;
    /**
     * Создает лист ingredientList который хранит лист ингридиентов
     * свзяь 1 ко многим. MappedBy указывает на то как эта свзяь будет выглядеть со стороны ingredient
     * fetch отвечает за подгрузку
     * LAZY ленивая подгрузка которая, подгружается только когда мы обращаемся к такому полю
     */
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "cocktail_ingredient",
            joinColumns = @JoinColumn(name = "cocktail_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id"))
    private List<Ingredient> ingredientList;
    /**
     * Создает лист riceptList который хранит лист рицептов
     * свзяь 1 ко многим. MappedBy указывает на то как эта свзяь будет выглядеть со стороны ricept
     * fetch отвечает за подгрузку
     * LAZY ленивая подгрузка которая, подгружается только когда мы обращаемся к такому полю
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cocktail", cascade = CascadeType.ALL)
    private List<Ricept> riceptList;
    /**
     * Создает виртуальную таблицу cocktail_tag который хранит связи cocktail_id и tag_id
     * joinColum отвечает за название поля со стороны сущности cocktails с названием name = "cocktail_id"
     * inverseJoinColumns отвечает за название поля со стороны сущности tags с названием name = "tag_id"
     * List<Genre> genreList - хранит список жанров
     */
    //@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @ManyToMany
    @JoinTable(
            name = "cocktail_tag",
            joinColumns = @JoinColumn(name = "cocktail_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private List<Tag> tagList;
}
