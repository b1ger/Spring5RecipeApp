package org.ontario.spring5recipeapp.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.ontario.spring5recipeapp.domain.Recipe;

@NoArgsConstructor
@Setter
@Getter
public class NotesCommand {

    private Long id;
    private Recipe recipe;
    private String recipeNotes;
}
