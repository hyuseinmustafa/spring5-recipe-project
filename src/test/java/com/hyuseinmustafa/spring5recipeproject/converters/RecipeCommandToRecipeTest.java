package com.hyuseinmustafa.spring5recipeproject.converters;

import com.hyuseinmustafa.spring5recipeproject.commands.CategoryCommand;
import com.hyuseinmustafa.spring5recipeproject.commands.IngredientCommand;
import com.hyuseinmustafa.spring5recipeproject.commands.NotesCommand;
import com.hyuseinmustafa.spring5recipeproject.commands.RecipeCommand;
import com.hyuseinmustafa.spring5recipeproject.domain.Difficulty;
import com.hyuseinmustafa.spring5recipeproject.domain.Recipe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecipeCommandToRecipeTest {

    public static final Long NOTES_ID = new Long(5L);
    public static final Long ID_VALUE = new Long(1L);
    public static final String DESCRIPTION = "description";
    public static final Integer PREP_TIME = new Integer(2);
    public static final Integer COOK_TIME = new Integer(3);
    public static final Integer SERVING = new Integer(4);
    public static final String SOURCE = "source";
    public static final String URL = "url";
    public static final String DIRECTIONS = "directions";
    public static final Difficulty DIFFICULTY = Difficulty.HARD;
    public static final NotesCommand NOTES = new NotesCommand();
    RecipeCommandToRecipe converter;

    @BeforeEach
    void setUp() {
        converter = new RecipeCommandToRecipe();
    }

    @Test
    void testNullObject(){
        assertNull(converter.convert(null));
    }

    @Test
    void testEmptyObject(){
        assertNotNull(converter.convert(new RecipeCommand()));
    }

    @Test
    void convert() {
        //given
        NOTES.setId(NOTES_ID);

        RecipeCommand source = new RecipeCommand();
        source.setId(ID_VALUE);
        source.setDescription(DESCRIPTION);
        source.setPrepTime(PREP_TIME);
        source.setCookTime(COOK_TIME);
        source.setServings(SERVING);
        source.setSource(SOURCE);
        source.setUrl(URL);
        source.setDirections(DIRECTIONS);
        source.setDifficulty(DIFFICULTY);
        source.setNotes(NOTES);
        source.getIngredients().add(new IngredientCommand(2L));
        source.getIngredients().add(new IngredientCommand(3L));
        source.getCategories().add(new CategoryCommand(4L));
        source.getCategories().add(new CategoryCommand(5L));
        source.getCategories().add(new CategoryCommand(6L));

        //when
        Recipe target = converter.convert(source);

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
        assertEquals(2, target.getIngredients().size());
        assertEquals(3, target.getCategories().size());
    }
}