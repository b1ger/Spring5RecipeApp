package org.ontario.spring5recipeapp.domain;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class IngredientTest {

    private Ingredient ingredient;
    private String desc = "TestDescription";
    private BigDecimal amount = new BigDecimal(1);
    @Mock
    private UnitOfMeasure uom;

    @Before
    public void setUp() throws Exception {
        ingredient = new Ingredient(desc, amount, uom);
    }

    @Test
    public void getId() {
        Long actualId = 1L;
        ingredient.setId(actualId);
        assertEquals(actualId, ingredient.getId());
    }

    @Test
    public void getDescription() {
        assertEquals(desc, ingredient.getDescription());
    }

    @Test
    public void getAmount() {
        assertEquals(amount, ingredient.getAmount());
    }

    @Test
    public void getUom() {
        assertEquals(uom, ingredient.getUom());
    }
}