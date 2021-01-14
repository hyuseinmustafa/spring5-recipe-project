package com.hyuseinmustafa.spring5recipeproject.services;

import com.hyuseinmustafa.spring5recipeproject.commands.RecipeCommand;
import com.hyuseinmustafa.spring5recipeproject.domain.Recipe;

import java.util.Optional;
import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipes();
    Recipe findById(Long id);
    void deleteById(Long id);
    RecipeCommand findCommandById(Long id);
    RecipeCommand saveRecipeCommand(RecipeCommand recipeCommand);
}
