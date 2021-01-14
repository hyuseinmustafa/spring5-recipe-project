package com.hyuseinmustafa.spring5recipeproject.controllers;

import com.hyuseinmustafa.spring5recipeproject.commands.RecipeCommand;
import com.hyuseinmustafa.spring5recipeproject.converters.RecipeToRecipeCommand;
import com.hyuseinmustafa.spring5recipeproject.domain.Recipe;
import com.hyuseinmustafa.spring5recipeproject.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/recipe/{id}/show")
    public String showById(@PathVariable String id, Model model){

        model.addAttribute("recipe", recipeService.findById(new Long(id)));

        return "recipe/show";
    }

    @GetMapping("/recipe/new")
    public String newRecipe(Model model){
        model.addAttribute("recipe", new RecipeCommand());

        return "recipe/recipeform";
    }

    @GetMapping("/recipe/{id}/update")
    public String updateRecipe(@PathVariable String id, Model model){
        model.addAttribute("recipe", recipeService.findCommandById(new Long(id)));

        return "recipe/recipeform";
    }

    @GetMapping("/recipe/{id}/delete")
    public String deleteRecipe(@PathVariable String id){
        recipeService.deleteById(new Long(id));
        return "redirect:/";
    }

    @PostMapping("/recipe/save")
    public String saveOrUpdate(@ModelAttribute RecipeCommand command){

        RecipeCommand savedRecipe = recipeService.saveRecipeCommand(command);

        return "redirect:/recipe/" + savedRecipe.getId() + "/show";
    }
}
