package com.hyuseinmustafa.spring5recipeproject.converters;

import com.hyuseinmustafa.spring5recipeproject.commands.UnitOfMeasureCommand;
import com.hyuseinmustafa.spring5recipeproject.domain.UnitOfMeasure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnitOfMeasureCommandToUnitOfMeasureTest {

    public static final Long ID_VALUE = new Long(1L);
    public static final String DESCRIPTION = "description";
    UnitOfMeasureCommandToUnitOfMeasure converter;

    @BeforeEach
    void setUp() {
        converter = new UnitOfMeasureCommandToUnitOfMeasure();
    }

    @Test
    void testNullObject(){
        assertNull(converter.convert(null));
    }

    @Test
    void testEmptyObject(){
        assertNotNull(converter.convert(new UnitOfMeasureCommand()));
    }

    @Test
    void convert() {
        //given
        UnitOfMeasureCommand source = new UnitOfMeasureCommand();
        source.setId(ID_VALUE);
        source.setDescription(DESCRIPTION);

        //when
        UnitOfMeasure target = converter.convert(source);

        //then
        assertNotNull(target);
        assertEquals(ID_VALUE, target.getId());
        assertEquals(DESCRIPTION, target.getDescription());
    }
}