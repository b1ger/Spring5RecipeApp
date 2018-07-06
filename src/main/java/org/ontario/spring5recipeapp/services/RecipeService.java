package org.ontario.spring5recipeapp.services;

import org.ontario.spring5recipeapp.commands.RecipeCommand;
import org.ontario.spring5recipeapp.domain.Recipe;

import java.util.Set;

/**
 * Created by jt on 6/13/17.
 */
public interface RecipeService {

    Set<Recipe> getRecipes();

    Recipe getRecipeById(Long l);

    RecipeCommand saveRecipeCommand(RecipeCommand command);
}
