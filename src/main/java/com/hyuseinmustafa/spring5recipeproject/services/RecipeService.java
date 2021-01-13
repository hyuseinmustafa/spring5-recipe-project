package com.hyuseinmustafa.spring5recipeproject.services;

import com.hyuseinmustafa.spring5recipeproject.domain.Recipe;

import java.util.Optional;
import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipes();
    Recipe findById(Long id);
}
