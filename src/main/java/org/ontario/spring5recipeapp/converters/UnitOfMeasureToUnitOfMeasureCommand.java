package org.ontario.spring5recipeapp.converters;

import lombok.Synchronized;
import org.ontario.spring5recipeapp.commands.UomCommand;
import org.ontario.spring5recipeapp.domain.UnitOfMeasure;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class UnitOfMeasureToUnitOfMeasureCommand implements Converter<UnitOfMeasure, UomCommand> {

    @Synchronized
    @Nullable
    @Override
    public UomCommand convert(UnitOfMeasure unitOfMeasure) {

        if (unitOfMeasure != null) {
            final UomCommand uomc = new UomCommand();
            uomc.setId(unitOfMeasure.getId());
            uomc.setDescription(unitOfMeasure.getDescription());
            return uomc;
        }
        return null;
    }
}
