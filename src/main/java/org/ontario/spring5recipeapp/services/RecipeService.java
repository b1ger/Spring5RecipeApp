package org.ontario.spring5recipeapp.services;

import org.ontario.spring5recipeapp.domain.Recipe;
import org.ontario.spring5recipeapp.repositories.RecipeRepository;

import java.util.List;

public class RecipeService {

    private RecipeRepository recipeRepository;

    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public List<Recipe> getRecipes() {
        return (List<Recipe>) recipeRepository.findAll();
    }
}
