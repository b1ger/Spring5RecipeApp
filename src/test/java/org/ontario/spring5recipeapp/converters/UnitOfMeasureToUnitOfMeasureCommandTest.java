package org.ontario.spring5recipeapp.converters;

import org.junit.Before;
import org.junit.Test;
import org.ontario.spring5recipeapp.commands.UomCommand;
import org.ontario.spring5recipeapp.domain.UnitOfMeasure;

import static org.junit.Assert.*;

public class UnitOfMeasureToUnitOfMeasureCommandTest {

    private static final String DESCRIPTION = "description";
    private static final Long LONG_VALUE = new Long(1L);
    private UnitOfMeasureToUnitOfMeasureCommand converter;

    @Before
    public void setUp() throws Exception {
        converter = new UnitOfMeasureToUnitOfMeasureCommand();
    }

    @Test
    public void testNullObjectConvert() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObj() throws Exception {
        assertNotNull(converter.convert(new UnitOfMeasure()));
    }

    @Test
    public void convert() throws Exception {
        UnitOfMeasure uom = new UnitOfMeasure();
        uom.setId(LONG_VALUE);
        uom.setDescription(DESCRIPTION);

        UomCommand uomc = converter.convert(uom);

        assertEquals(LONG_VALUE, uomc.getId());
        assertEquals(DESCRIPTION, uomc.getDescription());
    }
}
