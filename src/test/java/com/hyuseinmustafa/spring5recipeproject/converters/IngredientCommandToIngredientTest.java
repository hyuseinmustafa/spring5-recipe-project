package com.hyuseinmustafa.spring5recipeproject.converters;

import com.hyuseinmustafa.spring5recipeproject.commands.IngredientCommand;
import com.hyuseinmustafa.spring5recipeproject.commands.UnitOfMeasureCommand;
import com.hyuseinmustafa.spring5recipeproject.domain.Ingredient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class IngredientCommandToIngredientTest {

    public static final Long UOM_ID = new Long(6L);
    public static final Long ID_VALUE = new Long(1L);
    public static final BigDecimal AMOUNT = new BigDecimal(2);
    public static final String DESCRIPTION = "description";
    public static final UnitOfMeasureCommand UOM = new UnitOfMeasureCommand();
    IngredientCommandToIngredient converter;

    @BeforeEach
    void setUp() {
        converter = new IngredientCommandToIngredient();
    }

    @Test
    void testNullObject(){
        assertNull(converter.convert(null));
    }

    @Test
    void testEmptyObject(){
        assertNotNull(converter.convert(new IngredientCommand()));
    }

    @Test
    void convert() {
        //given
        UOM.setId(UOM_ID);
        IngredientCommand source = new IngredientCommand();
        source.setId(ID_VALUE);
        source.setAmount(AMOUNT);
        source.setDescription(DESCRIPTION);
        source.setUom(UOM);

        //when
        Ingredient target = converter.convert(source);

        //then
        assertNotNull(target);
        assertEquals(ID_VALUE, target.getId());
        assertEquals(AMOUNT, target.getAmount());
        assertEquals(DESCRIPTION, target.getDescription());
        assertEquals(UOM_ID, target.getUom().getId());
    }
}