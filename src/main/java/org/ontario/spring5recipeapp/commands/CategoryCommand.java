package org.ontario.spring5recipeapp.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.ontario.spring5recipeapp.domain.Recipe;

import java.util.Set;

@NoArgsConstructor
@Setter
@Getter
public class CategoryCommand {

    private Long id;
    private String description;
    private Set<Recipe> recipes;
}
