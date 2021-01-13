package com.hyuseinmustafa.spring5recipeproject.commands;

import com.hyuseinmustafa.spring5recipeproject.domain.Recipe;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class NotesCommand {
    private Long id;
    private String recipeNotes;
}
