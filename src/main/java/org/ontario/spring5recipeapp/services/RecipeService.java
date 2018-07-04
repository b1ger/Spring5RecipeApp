package org.ontario.spring5recipeapp.services;

import org.ontario.spring5recipeapp.domain.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();
}
