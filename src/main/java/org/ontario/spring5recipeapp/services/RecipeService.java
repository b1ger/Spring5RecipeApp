package org.ontario.spring5recipeapp.services;

import lombok.extern.slf4j.Slf4j;
import org.ontario.spring5recipeapp.domain.Recipe;
import org.ontario.spring5recipeapp.repositories.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class RecipeService {

    private RecipeRepository recipeRepository;

    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public List<Recipe> getRecipes() {
        log.debug("I'm in the service.");

        return (List<Recipe>) recipeRepository.findAll();
    }
}
