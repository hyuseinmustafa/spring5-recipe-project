package com.hyuseinmustafa.spring5recipeproject.converters;

import com.hyuseinmustafa.spring5recipeproject.commands.RecipeCommand;
import com.hyuseinmustafa.spring5recipeproject.domain.Recipe;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class RecipeCommandToRecipe implements Converter<RecipeCommand, Recipe> {

    @Synchronized
    @Override
    public Recipe convert(RecipeCommand source){
        if(source == null) return null;

        Recipe target = new Recipe();
        target.setId(source.getId());
        target.setDescription(source.getDescription());
        target.setPrepTime(source.getPrepTime());
        target.setCookTime(source.getCookTime());
        target.setServings(source.getServings());
        target.setSource(source.getSource());
        target.setUrl(source.getUrl());
        target.setDirections(source.getDirections());
        target.setDifficulty(source.getDifficulty());
        target.setNotes(new NotesCommandToNotes().convert(source.getNotes()));
        source.getIngredients().forEach(ingredient ->
                target.getIngredients().add(new IngredientCommandToIngredient().convert(ingredient)));
        source.getCategories().forEach(category ->
                target.getCategories().add(new CategoryCommandToCategory().convert(category)));
        return target;
    }
}
