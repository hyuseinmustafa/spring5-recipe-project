package com.hyuseinmustafa.spring5recipeproject.converters;

import com.hyuseinmustafa.spring5recipeproject.commands.NotesCommand;
import com.hyuseinmustafa.spring5recipeproject.domain.Category;
import com.hyuseinmustafa.spring5recipeproject.domain.Notes;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class NotesCommandToNotes implements Converter<NotesCommand, Notes> {

    @Synchronized
    @Override
    public Notes convert(NotesCommand source){
        if(source == null)return null;

        final Notes target = new Notes();
        target.setId(source.getId());
        target.setRecipeNotes(source.getRecipeNotes());
        return target;
    }
}
