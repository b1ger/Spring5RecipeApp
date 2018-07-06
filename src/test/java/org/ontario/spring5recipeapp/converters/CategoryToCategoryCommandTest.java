package org.ontario.spring5recipeapp.converters;

import org.junit.Before;
import org.junit.Test;
import org.ontario.spring5recipeapp.commands.CategoryCommand;
import org.ontario.spring5recipeapp.domain.Category;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyLong;

public class CategoryToCategoryCommandTest {

    private CategoryToCategoryCommand converter;
    private static final Long ID_VALUE = new Long(anyLong());
    private static final String DESCRIPTION = "DESCRIPTION";

    @Before
    public void setUp() throws Exception {
        converter = new CategoryToCategoryCommand();
    }

    @Test
    public void testNullObject() {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() {
        assertNotNull(converter.convert(new Category()));
    }

    @Test
    public void convert() {
        Category category = new Category();
        category.setId(ID_VALUE);
        category.setDescription(DESCRIPTION);

        CategoryCommand command = converter.convert(category);

        assertEquals(ID_VALUE, command.getId());
        assertEquals(DESCRIPTION, command.getDescription());
    }
}
