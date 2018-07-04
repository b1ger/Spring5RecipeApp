package org.ontario.spring5recipeapp.controllers;

import lombok.extern.slf4j.Slf4j;
import org.ontario.spring5recipeapp.domain.Recipe;
import org.ontario.spring5recipeapp.services.RecipeServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

@Slf4j
@Controller
public class IndexController {

    private RecipeServiceImpl recipeServiceImpl;

    public IndexController(RecipeServiceImpl recipeServiceImpl) {
        this.recipeServiceImpl = recipeServiceImpl;
    }

    @RequestMapping({"", "/", "/index"})
    public String indexAction(Model model) {
        log.debug("Call IndexController -> indexAction()");

        Set<Recipe> recipes = recipeServiceImpl.getRecipes();
        model.addAttribute("recipes", recipes);

        return "index";
    }
}
