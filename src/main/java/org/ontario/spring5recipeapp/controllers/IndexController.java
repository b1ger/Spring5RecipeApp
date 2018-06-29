package org.ontario.spring5recipeapp.controllers;

import org.ontario.spring5recipeapp.domain.Recipe;
import org.ontario.spring5recipeapp.repositories.CategoryRepository;
import org.ontario.spring5recipeapp.repositories.UnitOfMeasureRepository;
import org.ontario.spring5recipeapp.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class IndexController {

    private RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"", "/", "/index"})
    public String indexAction() {

        List<Recipe> recipes = recipeService.getRecipes();

        System.out.println(recipes.get(0).getNotes().getRecipeNotes());

        return "index";
    }
}
