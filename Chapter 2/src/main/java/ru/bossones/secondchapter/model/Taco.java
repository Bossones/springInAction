package ru.bossones.secondchapter.model;

import lombok.Data;

import java.util.List;

/**
 * Блюдо - Тако.
 */
@Data
public class Taco {

    private String name;

    private List<Ingredient> ingredients;
}
