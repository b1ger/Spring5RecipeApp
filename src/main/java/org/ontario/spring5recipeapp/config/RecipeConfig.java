package org.ontario.spring5recipeapp.config;

import org.ontario.spring5recipeapp.converters.RecipeCommandToRecipe;
import org.ontario.spring5recipeapp.converters.RecipeToRecipeCommand;
import org.ontario.spring5recipeapp.repositories.RecipeRepository;
import org.ontario.spring5recipeapp.services.RecipeServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RecipeConfig {

    @Bean
    RecipeServiceImpl recipeService(RecipeRepository recipeRepository, RecipeCommandToRecipe recipeCommandToRecipe, RecipeToRecipeCommand recipeToRecipeCommand) {
        return new RecipeServiceImpl(recipeRepository, recipeCommandToRecipe, recipeToRecipeCommand);
    }
}
