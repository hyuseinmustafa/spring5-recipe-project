package com.hyuseinmustafa.spring5recipeproject.converters;

import com.hyuseinmustafa.spring5recipeproject.commands.CategoryCommand;
import com.hyuseinmustafa.spring5recipeproject.domain.Category;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CategoryToCategoryCommand implements Converter<Category, CategoryCommand> {

    @Synchronized
    @Override
    public CategoryCommand convert(Category source){
        if(source == null) return null;

        CategoryCommand target = new CategoryCommand();
        target.setId(source.getId());
        target.setDescription(source.getDescription());
        return target;
    }
}
