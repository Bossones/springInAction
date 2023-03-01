package ru.bossones.secondchapter.converter;


import static ru.bossones.secondchapter.model.Ingredient.INGREDIENTS;

import jakarta.annotation.PostConstruct;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.bossones.secondchapter.model.Ingredient;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {

    private final Map<String, Ingredient> ingredientMap = INGREDIENTS
            .stream()
            .collect(Collectors.toMap(Ingredient::getId, Function.identity()));

    @Override
    public Ingredient convert(String id) {
        return ingredientMap.get(id);
    }
}
