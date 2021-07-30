package com.drink.drink.service;

import com.drink.drink.dto.Cocktail.CocktailDtoCreate;
import com.drink.drink.dto.Cocktail.CocktailDtoForGetAll;
import com.drink.drink.dto.Cocktail.CocktailDtoForGetCocktail;
import com.drink.drink.exception.NotFoundException;
import com.drink.drink.model.Cocktail;
import com.drink.drink.model.Composition;
import com.drink.drink.model.Ingredient;
import com.drink.drink.model.Ricept;
import com.drink.drink.model.Tag;
import com.drink.drink.repository.CocktailRepository;
import com.drink.drink.repository.IngredientRepository;
import com.drink.drink.repository.RiceptRepository;
import com.drink.drink.repository.TagRepository;
import com.drink.drink.service.impl.CocktailServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CocktailServiceTest {

    @Autowired
    CocktailServiceImpl cocktailService;

    @MockBean
    CocktailRepository cocktailRepositoryMock;

    @MockBean
    TagRepository tagRepository;

    @MockBean
    RiceptRepository riceptRepository;

    @MockBean
    IngredientRepository ingredientRepository;

    @Test
    public void getAll() throws Exception {
        List<Cocktail> cocktailsMock = new ArrayList<>();
        cocktailsMock.add(getNewCocktail(getTags(), getRecepts(), getIngredients()));
        when(cocktailRepositoryMock.findAll()).thenReturn(cocktailsMock);

        List<Cocktail> cocktails = cocktailRepositoryMock.findAll();
        List<CocktailDtoForGetAll> dtoCocktails = cocktailService.getAll();

        Assert.assertEquals(cocktails.size(), dtoCocktails.size());
    }

    @Test
    public void getCocktailWhenPresent() throws Exception {
        Optional<Cocktail> cocktailMock = Optional.of(getNewCocktail(getTags(), getRecepts(), getIngredients()));
        when(cocktailRepositoryMock.findById(Mockito.anyInt())).thenReturn(cocktailMock);

        CocktailDtoForGetCocktail cocktailDto = cocktailService.getCocktail(1);
        Optional<Cocktail> cocktail = cocktailRepositoryMock.findById(1);

        Assert.assertNotNull(cocktailDto);
        Assert.assertEquals(CocktailDtoForGetCocktail.of(cocktail.get()).getId(), cocktailDto.getId());
    }

    @Test
    public void getCocktailWhenEmpty() throws Exception {
        Optional<Cocktail> cocktailMock = Optional.empty();
        when(cocktailRepositoryMock.findById(Mockito.anyInt())).thenReturn(cocktailMock);

        Assert.assertThrows(NotFoundException.class, () -> cocktailService.getCocktail(1));
    }

    @Test
    public void deletePresent() throws Exception {
        Optional<Cocktail> cocktailMock = Optional.of(getNewCocktail(getTags(), getRecepts(), getIngredients()));
        when(cocktailRepositoryMock.findById(Mockito.anyInt())).thenReturn(cocktailMock).thenReturn(cocktailMock).thenReturn(Optional.empty());
        Mockito.doNothing().when(cocktailRepositoryMock).delete(Mockito.any(Cocktail.class));

        cocktailRepositoryMock.findById(1);
        cocktailService.delete(cocktailMock.get().getId());
        Optional<Cocktail> cocktail = cocktailRepositoryMock.findById(1);

        //Assert.assertTrue(cocktail.isEmpty());
    }

    @Test
    public void deleteNotExist() throws Exception {
        Optional<Cocktail> cocktailMock = Optional.of(getNewCocktail(getTags(), getRecepts(), getIngredients()));
        when(cocktailRepositoryMock.findById(Mockito.anyInt())).thenReturn(cocktailMock).thenReturn(cocktailMock).thenReturn(Optional.empty());
        Mockito.doNothing().when(cocktailRepositoryMock).delete(Mockito.any(Cocktail.class));

        cocktailRepositoryMock.findById(1);
        cocktailService.delete(cocktailMock.get().getId());
        Optional<Cocktail> cocktail = cocktailRepositoryMock.findById(1);

        //Assert.assertTrue(cocktail.isEmpty());
    }

    @Test
    public void saveWithDependencies() throws Exception {
//        Cocktail cocktailMock = getNewCocktail(getTags(), getRecepts(), getIngredients());
//
//        when(tagRepository.findAllById(
//                cocktailMock.getTagList().stream()
//                        .map(Tag::getId).collect(Collectors.toList())))
//                .thenReturn(cocktailMock.getTagList());
//
//        when(riceptRepository.findAllById(
//                cocktailMock.getRiceptList().stream()
//                        .map(Ricept::getId).collect(Collectors.toList())))
//                .thenReturn(cocktailMock.getRiceptList());
//
//        when(ingredientRepository.findAllById(
//                cocktailMock.getIngredientList().stream()
//                        .map(Ingredient::getId).collect(Collectors.toList())))
//                .thenReturn(cocktailMock.getIngredientList());
//
//        when(cocktailRepositoryMock.save(Mockito.any(Cocktail.class))).thenReturn(Mockito.any(Cocktail.class));
//
//        CocktailDtoCreate cocktailDtoCreate = getDtoForCreateCocktail(cocktailMock);
//        cocktailService.save(cocktailDtoCreate);
    }

    @Test
    public void saveWithoutDependencies() throws Exception {
//        Cocktail cocktailMock = getNewCocktail(getTags(), getRecepts(), getIngredients());
//
//        when(tagRepository.findAllById(
//                cocktailMock.getTagList().stream()
//                        .map(Tag::getId).collect(Collectors.toList())))
//                .thenReturn(cocktailMock.getTagList());
//
//        when(cocktailRepositoryMock.save(Mockito.any(Cocktail.class))).thenReturn(Mockito.any(Cocktail.class));
//
//        CocktailDtoCreate cocktailDtoCreate = getDtoForCreateCocktail(cocktailMock);
//        try {
//            cocktailService.save(cocktailDtoCreate);
//            Assertions.fail("Should have Exception");
//        } catch (Exception e) {
//            Assertions.assertThat(e)
//                    .isInstanceOf(NotFoundException.class);
//        }
    }

    @Test
    public void update() throws Exception {
//        Cocktail cocktailMock = getNewCocktail(getTags(), getRecepts(), getIngredients());
//
//        when(cocktailRepositoryMock.findById(Mockito.anyInt())).thenReturn(Optional.of(cocktailMock));
//
//        when(tagRepository.findAllById(
//                cocktailMock.getTagList().stream()
//                        .map(Tag::getId).collect(Collectors.toList())))
//                .thenReturn(cocktailMock.getTagList());
//
//        when(riceptRepository.findAllById(
//                cocktailMock.getRiceptList().stream()
//                        .map(Ricept::getId).collect(Collectors.toList())))
//                .thenReturn(cocktailMock.getRiceptList());
//
//        when(ingredientRepository.findAllById(
//                cocktailMock.getIngredientList().stream()
//                        .map(Ingredient::getId).collect(Collectors.toList())))
//                .thenReturn(cocktailMock.getIngredientList());
//
//        when(cocktailRepositoryMock.save(Mockito.any(Cocktail.class))).thenReturn(Mockito.any(Cocktail.class));
//
//        CocktailDtoCreate cocktailDtoCreate = getDtoForCreateCocktail(cocktailMock);
//        cocktailService.save(cocktailDtoCreate);
    }

    private CocktailDtoCreate getDtoForCreateCocktail(Cocktail cocktail) {
        CocktailDtoCreate cocktailDto = new CocktailDtoCreate();
        cocktailDto.setAlcohol(cocktail.getAlcohol());
        cocktailDto.setName(cocktail.getName());
        cocktailDto.setComment(cocktail.getComment());
        cocktailDto.setPhotoUrl(cocktail.getPhotoUrl());

        List<Integer> list = new ArrayList<>();
        list.add(1);
        cocktailDto.setIngredientList(list);
        cocktailDto.setRiceptList(list);
        cocktailDto.setTagList(list);
        return cocktailDto;
    }

    private Cocktail getNewCocktail(List<Tag> tags, List<Ricept> ricepts, List<Ingredient> ingredients) {
        Cocktail cocktail = getNewCocktail();
        cocktail.setTagList(tags);
        cocktail.setRiceptList(ricepts);
        cocktail.setIngredientList(ingredients);
        return cocktail;
    }

    private Cocktail getNewCocktail() {
        Cocktail cocktail = new Cocktail();
        cocktail.setId(1);
        cocktail.setName("SomeName");
        cocktail.setPhotoUrl("url");
        cocktail.setAlcohol(40);
        cocktail.setComment("comment");
        return cocktail;
    }

    private List<Tag> getTags() {
        Tag tag = new Tag();
        tag.setId(1);
        tag.setName("name");
        List<Tag> tags = new ArrayList<>();
        tags.add(tag);
        return tags;
    }

    private List<Ingredient> getIngredients() {
        Ingredient ingredient = new Ingredient();
        ingredient.setId(1);
        ingredient.setName("name");
        ingredient.setCompositionList(getComposition());
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(ingredient);
        return ingredients;
    }

    private List<Composition> getComposition() {
        List<Composition> compositions = new ArrayList<>();
        Composition composition = new Composition();
        composition.setId(1);
        composition.setValue(100);
        composition.setUnit("one");
        compositions.add(composition);
        return compositions;
    }

    private List<Ricept> getRecepts() {
        Ricept ricept = new Ricept();
        ricept.setId(1);
        ricept.setDescription("description");
        List<Ricept> ricepts = new ArrayList<>();
        ricepts.add(ricept);
        return ricepts;
    }
}