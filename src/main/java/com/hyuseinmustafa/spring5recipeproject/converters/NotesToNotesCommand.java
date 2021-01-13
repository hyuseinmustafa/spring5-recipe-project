package com.hyuseinmustafa.spring5recipeproject.converters;

import com.hyuseinmustafa.spring5recipeproject.commands.NotesCommand;
import com.hyuseinmustafa.spring5recipeproject.domain.Notes;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class NotesToNotesCommand implements Converter<Notes, NotesCommand> {

    @Synchronized
    @Override
    public NotesCommand convert(Notes source){
        if(source == null)return null;

        final NotesCommand target = new NotesCommand();
        target.setId(source.getId());
        target.setRecipeNotes(source.getRecipeNotes());
        return target;
    }
}
