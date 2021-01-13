package com.hyuseinmustafa.spring5recipeproject.converters;

import com.hyuseinmustafa.spring5recipeproject.commands.UnitOfMeasureCommand;
import com.hyuseinmustafa.spring5recipeproject.domain.UnitOfMeasure;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UnitOfMeasureCommandToUnitOfMeasure implements Converter<UnitOfMeasureCommand, UnitOfMeasure> {

    @Synchronized
    @Override
    public UnitOfMeasure convert(UnitOfMeasureCommand source){
        if(source == null) return null;

        UnitOfMeasure target = new UnitOfMeasure();
        target.setId(source.getId());
        target.setDescription(source.getDescription());
        return target;
    }
}
