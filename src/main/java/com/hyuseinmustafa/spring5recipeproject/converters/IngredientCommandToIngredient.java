package com.hyuseinmustafa.spring5recipeproject.converters;

import com.hyuseinmustafa.spring5recipeproject.commands.IngredientCommand;
import com.hyuseinmustafa.spring5recipeproject.domain.Ingredient;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class IngredientCommandToIngredient implements Converter<IngredientCommand, Ingredient> {

    @Synchronized
    @Override
    public Ingredient convert(IngredientCommand source){
        if(source == null) return null;

        Ingredient target = new Ingredient();
        target.setId(source.getId());
        target.setAmount(source.getAmount());
        target.setDescription(source.getDescription());
        target.setUom(new UnitOfMeasureCommandToUnitOfMeasure().convert(source.getUom()));
        return target;
    }
}
