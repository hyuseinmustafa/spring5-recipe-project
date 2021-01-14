package com.hyuseinmustafa.spring5recipeproject.controllers;

import com.hyuseinmustafa.spring5recipeproject.commands.RecipeCommand;
import com.hyuseinmustafa.spring5recipeproject.domain.Recipe;
import com.hyuseinmustafa.spring5recipeproject.services.RecipeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class RecipeControllerTest {

    @Mock
    RecipeService service;

    RecipeController controller;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        controller = new RecipeController(service);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void showById() throws Exception {
        Recipe recipe = new Recipe();
        recipe.setId(1L);

        when(service.findById(anyLong())).thenReturn(recipe);

        mockMvc.perform(get("/recipe/1/show"))
                .andExpect(status().isOk())
                .andExpect(view().name("recipe/show"))
                .andExpect(model().attributeExists("recipe"));
    }

    @Test
    void newRecipe() throws Exception {
        mockMvc.perform(get("/recipe/new"))
                .andExpect(status().isOk())
                .andExpect(view().name("recipe/recipeform"))
                .andExpect(model().attributeExists("recipe"));
    }

    @Test
    void updateRecipe() throws Exception {
        RecipeCommand recipe = new RecipeCommand();
        recipe.setId(1L);

        when(service.findCommandById(anyLong())).thenReturn(recipe);

        mockMvc.perform(get("/recipe/1/update"))
                .andExpect(status().isOk())
                .andExpect(view().name("recipe/recipeform"))
                .andExpect(model().attributeExists("recipe"));
    }

    @Test
    void deleteRecipe() throws Exception {
        mockMvc.perform(get("/recipe/1/delete"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/"));

        verify(service, times(1)).deleteById(anyLong());
    }

    @Test
    void saveOrUpdate() throws Exception {
        RecipeCommand recipe = new RecipeCommand();
        recipe.setId(3L);

        when(service.saveRecipeCommand(any())).thenReturn(recipe);

        mockMvc.perform(post("/recipe/save")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("id", "")
                .param("descriptions","some string")
        )
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/recipe/3/show"));

        verify(service, times(1)).saveRecipeCommand(any());
    }
}