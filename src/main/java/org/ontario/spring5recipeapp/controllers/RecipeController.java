package org.ontario.spring5recipeapp.controllers;

import lombok.extern.slf4j.Slf4j;
import org.ontario.spring5recipeapp.domain.Recipe;
import org.ontario.spring5recipeapp.services.RecipeServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class RecipeController {

    private RecipeServiceImpl recipeService;

    public RecipeController(RecipeServiceImpl recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping("/recipe/view/{id}")
    public String viewAction(Model model, @PathVariable String id) {
        log.debug("Call RecipeController -> viewAction(), parameter id = " + id);

        Recipe recipe = recipeService.getRecipeById(Long.parseLong(id));
        model.addAttribute("recipe", recipe);

        return "recipe/view";
    }
}
