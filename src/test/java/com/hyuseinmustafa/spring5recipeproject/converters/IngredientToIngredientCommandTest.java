package com.hyuseinmustafa.spring5recipeproject.converters;

import com.hyuseinmustafa.spring5recipeproject.commands.IngredientCommand;
import com.hyuseinmustafa.spring5recipeproject.domain.Ingredient;
import com.hyuseinmustafa.spring5recipeproject.domain.UnitOfMeasure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class IngredientToIngredientCommandTest {

    public static final Long UOM_ID = new Long(6L);
    public static final Long ID_VALUE = new Long(1L);
    public static final BigDecimal AMOUNT = new BigDecimal(2);
    public static final String DESCRIPTION = "description";
    public static final UnitOfMeasure UOM = new UnitOfMeasure();
    IngredientToIngredientCommand converter;

    @BeforeEach
    void setUp() {
        converter = new IngredientToIngredientCommand();
    }

    @Test
    void testNullObject(){
        assertNull(converter.convert(null));
    }

    @Test
    void testEmptyObject(){
        assertNotNull(converter.convert(new Ingredient()));
    }

    @Test
    void convert() {
        //given
        UOM.setId(UOM_ID);

        Ingredient source = new Ingredient();
        source.setId(ID_VALUE);
        source.setAmount(AMOUNT);
        source.setDescription(DESCRIPTION);
        source.setUom(UOM);

        //when
        IngredientCommand target = converter.convert(source);

        //then
        assertNotNull(target);
        assertEquals(ID_VALUE, target.getId());
        assertEquals(AMOUNT, target.getAmount());
        assertEquals(DESCRIPTION, target.getDescription());
        assertEquals(UOM_ID, target.getUom().getId());
    }
}