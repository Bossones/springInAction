package ru.bossones.secondchapter.model;

import lombok.Data;
import ru.bossones.secondchapter.model.enums.IngredientType;

import java.util.List;

/**
 * Ингридиент.
 */
@Data
public class Ingredient {

    public static final List<Ingredient> INGREDIENTS = List.of(
            new Ingredient("FLTO", "Flour Tortilla", IngredientType.WRAP),
            new Ingredient("COTO", "Corn Tortilla", IngredientType.WRAP),
            new Ingredient("GRBF", "Ground Beef", IngredientType.PROTEIN),
            new Ingredient("CARN", "Carnitas", IngredientType.PROTEIN),
            new Ingredient("TMTO", "Diced Tomatoes", IngredientType.VEGGIES),
            new Ingredient("LETC", "Lettuce", IngredientType.VEGGIES),
            new Ingredient("CHED", "Cheddar", IngredientType.CHEESE),
            new Ingredient("JACK", "Monterrey Jack", IngredientType.CHEESE),
            new Ingredient("SLSA", "Salsa", IngredientType.SAUCE),
            new Ingredient("SRCR", "Sour Cream", IngredientType.SAUCE)
    );

    private final String id;
    private final String name;
    private final IngredientType type;
}
