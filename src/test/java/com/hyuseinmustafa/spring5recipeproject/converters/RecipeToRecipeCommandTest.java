package com.hyuseinmustafa.spring5recipeproject.converters;

import com.hyuseinmustafa.spring5recipeproject.commands.RecipeCommand;
import com.hyuseinmustafa.spring5recipeproject.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecipeToRecipeCommandTest {
    public static final Long NOTES_ID = new Long(5L);

    public static final Long ID_VALUE = new Long(1L);
    public static final String DESCRIPTION = "description";
    public static final Integer PREP_TIME = new Integer(2);
    public static final Integer COOK_TIME = new Integer(3);
    public static final Integer SERVING = new Integer(4);
    public static final String SOURCE = "source";
    public static final String URL = "url";
    public static final String DIRECTIONS = "directions";
    public static final Ingredient INGREDIENT = new Ingredient();
    public static final Difficulty DIFFICULTY = Difficulty.HARD;
    public static final Notes NOTES = new Notes();
    public static final Category CATEGORY = new Category();
    RecipeToRecipeCommand converter;


    @BeforeEach
    void setUp() {
        converter = new RecipeToRecipeCommand();
    }

    @Test
    void testNullObject(){
        assertNull(converter.convert(null));
    }

    @Test
    void testEmptyObject(){
        assertNotNull(converter.convert(new Recipe()));
    }

    @Test
    void convert() {
        //given
        NOTES.setId(NOTES_ID);

        Recipe source = new Recipe();
        source.setId(ID_VALUE);
        source.setDescription(DESCRIPTION);
        source.setPrepTime(PREP_TIME);
        source.setCookTime(COOK_TIME);
        source.setServings(SERVING);
        source.setSource(SOURCE);
        source.setUrl(URL);
        source.setDirections(DIRECTIONS);
        source.getIngredients().add(INGREDIENT);
        source.setDifficulty(DIFFICULTY);
        source.setNotes(NOTES);
        source.getCategories().add(CATEGORY);

        //when
        RecipeCommand target = converter.convert(source);

        //then
        assertNotNull(target);
        assertEquals(ID_VALUE, target.getId());
        assertEquals(DESCRIPTION, target.getDescription());
        assertEquals(PREP_TIME, target.getPrepTime());
        assertEquals(COOK_TIME, target.getCookTime());
        assertEquals(SERVING, target.getServings());
        assertEquals(SOURCE, target.getSource());
        assertEquals(URL, target.getUrl());
        assertEquals(DIRECTIONS, target.getDirections());
        assertEquals(DIFFICULTY, target.getDifficulty());
        assertEquals(NOTES_ID, target.getNotes().getId());
        assertEquals(1, target.getIngredients().size());
        assertEquals(1, target.getCategories().size());
    }
}