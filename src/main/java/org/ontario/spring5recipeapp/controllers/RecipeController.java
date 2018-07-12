package org.ontario.spring5recipeapp.controllers;

import lombok.extern.slf4j.Slf4j;
import org.ontario.spring5recipeapp.commands.CategoryCommand;
import org.ontario.spring5recipeapp.commands.RecipeCommand;
import org.ontario.spring5recipeapp.domain.Recipe;
import org.ontario.spring5recipeapp.repositories.CategoryRepository;
import org.ontario.spring5recipeapp.services.CategoryService;
import org.ontario.spring5recipeapp.services.RecipeService;
import org.ontario.spring5recipeapp.services.RecipeServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Set;

@Controller
@Slf4j
public class RecipeController {

    private RecipeService recipeService;
    private CategoryRepository categoryRepository;
    private CategoryService categoryService;

    public RecipeController(RecipeServiceImpl recipeService, CategoryRepository categoryRepository, CategoryService categoryService) {
        this.recipeService = recipeService;
        this.categoryRepository = categoryRepository;
        this.categoryService = categoryService;
    }

    @RequestMapping("/recipe/{id}/view")
    public String viewAction(Model model, @PathVariable String id) {
        log.debug("Call RecipeController -> viewAction(), parameter id = " + id);

        Recipe recipe = recipeService.findById(Long.parseLong(id));
        model.addAttribute("recipe", recipe);

        return "recipe/view";
    }

    @RequestMapping("/recipe/new")
    public String createAction(Model model) {
        model.addAttribute("recipe", new RecipeCommand());
        return "recipe/recipeform";
    }

    @RequestMapping("/recipe/{id}/update")
    public String updateRecipeAction(Model model, @PathVariable String id) {
        model.addAttribute("recipe", recipeService.findCommandById(Long.valueOf(id)));
        model.addAttribute("categories", categoryService.listAllCategories());
        return "recipe/recipeform";
    }

    @PostMapping
    @RequestMapping("recipe")
    public String saveOrUpdateRecipe(@ModelAttribute RecipeCommand recipeCommand) {
        RecipeCommand saveCommand = recipeService.saveRecipeCommand(recipeCommand);
        return "redirect:/recipe/" + saveCommand.getId() + "/view";
    }

    @RequestMapping("/recipe/{id}/delete")
    public String deleteRecipeAction(@PathVariable String id) {
        recipeService.deleteById(new Long(id));
        return "redirect:/";
    }
}
