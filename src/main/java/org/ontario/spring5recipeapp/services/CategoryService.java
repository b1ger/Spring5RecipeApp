package org.ontario.spring5recipeapp.services;

import org.ontario.spring5recipeapp.commands.CategoryCommand;

import java.util.Set;

public interface CategoryService {

    Set<CategoryCommand> listAllCategories();
}
