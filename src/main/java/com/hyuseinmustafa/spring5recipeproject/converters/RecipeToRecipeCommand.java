package com.hyuseinmustafa.spring5recipeproject.converters;

import com.hyuseinmustafa.spring5recipeproject.commands.RecipeCommand;
import com.hyuseinmustafa.spring5recipeproject.domain.Recipe;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class RecipeToRecipeCommand implements Converter<Recipe, RecipeCommand> {

    @Synchronized
    @Override
    public RecipeCommand convert(Recipe source){
        if(source == null) return null;

        RecipeCommand target = new RecipeCommand();
        target.setId(source.getId());
        target.setDescription(source.getDescription());
        target.setPrepTime(source.getPrepTime());
        target.setCookTime(source.getCookTime());
        target.setServings(source.getServings());
        target.setSource(source.getSource());
        target.setUrl(source.getUrl());
        target.setDirections(source.getDirections());
        target.setDifficulty(source.getDifficulty());
        target.setNotes(new NotesToNotesCommand().convert(source.getNotes()));
        source.getIngredients().forEach(ingredient ->
                target.getIngredients().add(new IngredientToIngredientCommand().convert(ingredient)));
        source.getCategories().forEach(category ->
                target.getCategories().add(new CategoryToCategoryCommand().convert(category)));
        return target;
    }
}
