package com.hyuseinmustafa.spring5recipeproject.commands;

import com.hyuseinmustafa.spring5recipeproject.domain.UnitOfMeasure;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class IngredientCommand {
    private Long id;
    private String description;
    private String amount;
    private UnitOfMeasureCommand uom;
}
