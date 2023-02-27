package ru.bossones.secondchapter.model;

import lombok.Data;
import ru.bossones.secondchapter.model.enums.IngridientType;

/**
 * Ингридиент.
 */
@Data
public class Ingredient {

    private final String id;
    private final String name;
    private final IngridientType type;
}
