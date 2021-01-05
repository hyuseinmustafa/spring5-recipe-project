package com.hyuseinmustafa.spring5recipeproject.repositories;

import com.hyuseinmustafa.spring5recipeproject.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
