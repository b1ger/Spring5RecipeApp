package org.ontario.spring5recipeapp.controllers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.ontario.spring5recipeapp.domain.Recipe;
import org.ontario.spring5recipeapp.services.RecipeServiceImpl;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class RecipeControllerTest {

    @Mock
    private RecipeServiceImpl recipeService;

    private RecipeController controller;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        controller = new RecipeController(recipeService);
    }

    @Test
    public void viewActionTest() throws Exception {
        Recipe recipe = new Recipe();
        recipe.setId(1L);

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        when(recipeService.getRecipeById(anyLong())).thenReturn(recipe);

        mockMvc.perform(get("/recipe/view/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("recipe/view"))
                .andExpect(model().attributeExists("recipe"));
    }
}