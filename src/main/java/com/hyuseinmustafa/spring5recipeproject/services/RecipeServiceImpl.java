package com.hyuseinmustafa.spring5recipeproject.services;

import com.hyuseinmustafa.spring5recipeproject.commands.RecipeCommand;
import com.hyuseinmustafa.spring5recipeproject.converters.RecipeCommandToRecipe;
import com.hyuseinmustafa.spring5recipeproject.converters.RecipeToRecipeCommand;
import com.hyuseinmustafa.spring5recipeproject.domain.Recipe;
import com.hyuseinmustafa.spring5recipeproject.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService {
    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Set<Recipe> getRecipes() {
        log.debug("I'm in the service");

        Set<Recipe> recipeSet = new HashSet<>();
        recipeRepository.findAll().iterator().forEachRemaining(recipeSet::add);
        return recipeSet;
    }

    @Override
    public Recipe findById(Long id) {

        Optional<Recipe> recipeOptional = recipeRepository.findById(id);

        if (!recipeOptional.isPresent()) {
            throw new RuntimeException("Recipe not found!");
        }

        return recipeOptional.get();
    }

    @Override
    public void deleteById(Long id) {
        recipeRepository.deleteById(id);
    }

    @Override
    @Transactional
    public RecipeCommand findCommandById(Long id) {
        return new RecipeToRecipeCommand().convert(this.findById(id));
    }

    @Override
    @Transactional
    public RecipeCommand saveRecipeCommand(RecipeCommand recipeCommand) {
        Recipe recipe = new RecipeCommandToRecipe().convert(recipeCommand);
        recipeRepository.save(recipe);

        return new RecipeToRecipeCommand().convert(recipe);
    }
}
