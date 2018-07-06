package org.ontario.spring5recipeapp.converters;

import org.junit.Before;
import org.junit.Test;
import org.ontario.spring5recipeapp.commands.CategoryCommand;
import org.ontario.spring5recipeapp.domain.Category;

import static org.junit.Assert.*;

public class CategoryCommandToCategoryTest {

    private static final Long ID_VALUE = new Long(5L);
    private static final String DESCRIPTION = "description";
    private CategoryCommandToCategory converter;

    @Before
    public void setUp() throws Exception {
        converter = new CategoryCommandToCategory();
    }

    @Test
    public void testNullObject() {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() {
        assertNotNull(converter.convert(new CategoryCommand()));
    }

    @Test
    public void convert() {
        CategoryCommand categoryCommand = new CategoryCommand();
        categoryCommand.setId(ID_VALUE);
        categoryCommand.setDescription(DESCRIPTION);

        Category category = converter.convert(categoryCommand);

        assertEquals(ID_VALUE, category.getId());
        assertEquals(DESCRIPTION, category.getDescription());
    }
}
