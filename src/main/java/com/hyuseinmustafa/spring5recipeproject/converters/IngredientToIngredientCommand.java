package com.hyuseinmustafa.spring5recipeproject.converters;

import com.hyuseinmustafa.spring5recipeproject.commands.IngredientCommand;
import com.hyuseinmustafa.spring5recipeproject.domain.Ingredient;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class IngredientToIngredientCommand implements Converter<Ingredient, IngredientCommand> {

    @Synchronized
    @Override
    public IngredientCommand convert(Ingredient source){
        if(source == null) return null;

        IngredientCommand target = new IngredientCommand();
        target.setId(source.getId());
        target.setAmount(source.getAmount());
        target.setDescription(source.getDescription());
        target.setUom(new UnitOfMeasureToUnitOfMeasureCommand().convert(source.getUom()));
        return target;
    }
}
