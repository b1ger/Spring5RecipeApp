package org.ontario.spring5recipeapp.controllers;

import lombok.extern.slf4j.Slf4j;
import org.ontario.spring5recipeapp.commands.IngredientCommand;
import org.ontario.spring5recipeapp.commands.RecipeCommand;
import org.ontario.spring5recipeapp.services.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
public class IngredientController {

    private RecipeService recipeService;
    private UnitOfMeasureService uomService;
    private IngredientService ingredientService;

    public IngredientController(RecipeService recipeService, UnitOfMeasureService uomService, IngredientService ingredientService) {
        this.recipeService = recipeService;
        this.uomService = uomService;
        this.ingredientService = ingredientService;
    }

    @GetMapping
    @RequestMapping("/recipe/{recipeId}/ingredients")
    public String getRecipeListAction(Model model, @PathVariable String recipeId) {
        model.addAttribute("recipe", recipeService.findCommandById(Long.valueOf(recipeId)));
        return "recipe/ingredient/list";
    }

    @GetMapping
    @RequestMapping("/recipe/{recipeId}/ingredient/{id}/view")
    public String viewIngredientAction(Model model,
                                       @PathVariable String recipeId,
                                       @PathVariable String id) {
        model.addAttribute("ingredient", ingredientService.findByRecipeIdAndIngredientId(new Long(recipeId), new Long(id)));
        return "recipe/ingredient/view";
    }

    @GetMapping
    @RequestMapping("/recipe/{recipeId}/ingredient/new")
    public String createAction(Model model, @PathVariable String recipeId) {
        RecipeCommand recipeCommand = recipeService.findCommandById(Long.valueOf(recipeId));
        // todo reise exception if full
        IngredientCommand ingredient = new IngredientCommand();
        ingredient.setRecipeId(recipeCommand.getId());
        model.addAttribute("ingredient", ingredient);
        model.addAttribute("uomList", uomService.listAllUoms());
        return "recipe/ingredient/ingredientform";
    }

    @RequestMapping("recipe/{recipeId}/ingredient/{id}/update")
    public String updateIngredientAction(Model model,
                                         @PathVariable String recipeId,
                                         @PathVariable String id) {
        model.addAttribute("ingredient", ingredientService.findByRecipeIdAndIngredientId(Long.valueOf(recipeId), Long.valueOf(id)));
        model.addAttribute("uomList", uomService.listAllUoms());

        return "recipe/ingredient/ingredientform";
    }

    @PostMapping
    @RequestMapping("/recipe/{recipeId}/ingredient")
    public String saveOrUpdateIngredientAction(@ModelAttribute IngredientCommand ingredientCommand,
                                               @PathVariable String recipeId) {

        IngredientCommand savedCommand = ingredientService.saveIngredientCommand(ingredientCommand);

        log.debug("saved receipe id:" + savedCommand.getRecipeId());
        log.debug("saved ingredient id:" + savedCommand.getId());

        return "redirect:/recipe/" + savedCommand.getRecipeId() + "/ingredient/" + savedCommand.getId() + "/view";
    }
}
