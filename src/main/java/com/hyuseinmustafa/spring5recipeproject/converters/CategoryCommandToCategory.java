package com.hyuseinmustafa.spring5recipeproject.converters;

import com.hyuseinmustafa.spring5recipeproject.commands.CategoryCommand;
import com.hyuseinmustafa.spring5recipeproject.domain.Category;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CategoryCommandToCategory implements Converter<CategoryCommand, Category>{

    @Synchronized
    @Override
    public Category convert(CategoryCommand source){
        if(source == null)return null;

        final Category target = new Category();
        target.setId(source.getId());
        target.setDescription(source.getDescription());
        return target;
    }
}
