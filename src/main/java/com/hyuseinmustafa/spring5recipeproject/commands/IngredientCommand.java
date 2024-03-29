package com.hyuseinmustafa.spring5recipeproject.commands;

import com.hyuseinmustafa.spring5recipeproject.domain.UnitOfMeasure;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
public class IngredientCommand {
    private Long id;
    private String description;
    private BigDecimal amount;
    private UnitOfMeasureCommand uom;

    public IngredientCommand(Long id) {
        this.id = id;
    }
}
