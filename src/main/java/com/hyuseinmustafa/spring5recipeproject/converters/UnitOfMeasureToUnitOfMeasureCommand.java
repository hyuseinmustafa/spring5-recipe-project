package com.hyuseinmustafa.spring5recipeproject.converters;

import com.hyuseinmustafa.spring5recipeproject.commands.UnitOfMeasureCommand;
import com.hyuseinmustafa.spring5recipeproject.domain.UnitOfMeasure;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UnitOfMeasureToUnitOfMeasureCommand implements Converter<UnitOfMeasure, UnitOfMeasureCommand> {

    @Synchronized
    public UnitOfMeasureCommand convert(UnitOfMeasure source){
        if(source == null) return null;

        UnitOfMeasureCommand target = new UnitOfMeasureCommand();
        target.setId(source.getId());
        target.setDescription(source.getDescription());
        return target;
    }
}
