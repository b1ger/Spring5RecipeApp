package org.ontario.spring5recipeapp.converters;

import org.junit.Before;
import org.junit.Test;
import org.ontario.spring5recipeapp.commands.UomCommand;
import org.ontario.spring5recipeapp.domain.UnitOfMeasure;

import static org.junit.Assert.*;

public class UnitOfMeasureCommandToUnitOfMeasureTest {

    private static final String DESCRIPTION = "description";
    private static final Long LONG_VALUE = new Long(1L);
    private UnitOfMeasureCommandToUnitOfMeasure converter;

    @Before
    public void setUp() throws Exception {
        converter = new UnitOfMeasureCommandToUnitOfMeasure();

    }

    @Test
    public void testNullParamter() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new UomCommand()));
    }

    @Test
    public void convert() throws Exception {
        UomCommand command = new UomCommand();
        command.setId(LONG_VALUE);
        command.setDescription(DESCRIPTION);

        UnitOfMeasure uom = converter.convert(command);

        assertNotNull(uom);
        assertEquals(LONG_VALUE, uom.getId());
        assertEquals(DESCRIPTION, uom.getDescription());
    }
}
