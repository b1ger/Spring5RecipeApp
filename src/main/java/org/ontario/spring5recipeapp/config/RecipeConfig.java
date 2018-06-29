package org.ontario.spring5recipeapp.config;

import org.ontario.spring5recipeapp.repositories.RecipeRepository;
import org.ontario.spring5recipeapp.services.RecipeService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RecipeConfig {

    @Bean
    RecipeService recipeService(RecipeRepository recipeRepository) {
        return new RecipeService(recipeRepository);
    }
}
