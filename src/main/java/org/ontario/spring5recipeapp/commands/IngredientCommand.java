package org.ontario.spring5recipeapp.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.ontario.spring5recipeapp.domain.Recipe;

import java.math.BigDecimal;

@NoArgsConstructor
@Setter
@Getter
public class IngredientCommand {

    private Long id;
    private String description;
    private BigDecimal amount;
    private UomCommand unitOfMeasure;
    private Recipe recipe;
}
