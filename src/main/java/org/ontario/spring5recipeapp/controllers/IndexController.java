package org.ontario.spring5recipeapp.controllers;

import org.ontario.spring5recipeapp.domain.Category;
import org.ontario.spring5recipeapp.domain.UnitOfMeasure;
import org.ontario.spring5recipeapp.repositories.CategoryRepository;
import org.ontario.spring5recipeapp.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping({"", "/", "/index"})
    public String indexAction() {

        Optional<Category> optionalCategory = categoryRepository.findByDescription("American");
        Optional<UnitOfMeasure> optionalUnitOfMeasure = unitOfMeasureRepository.findByDescription("Teaspoon");

        System.out.println(optionalCategory.get().getDescription());
        System.out.println(optionalUnitOfMeasure.get().getDescription());

        return "index";
    }
}
