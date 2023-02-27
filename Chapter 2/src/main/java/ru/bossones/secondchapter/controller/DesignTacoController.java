package ru.bossones.secondchapter.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import ru.bossones.secondchapter.model.Ingredient;
import ru.bossones.secondchapter.model.TacoOrder;
import ru.bossones.secondchapter.model.enums.IngridientType;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("tacoOrder")
public class DesignTacoController {

    @ModelAttribute
    public void addIngredientsToModel(Model model) {
        List<Ingredient> ingredients = List.of(
                new Ingredient("FLTO", "Flour Tortilla", IngridientType.WRAP),
                new Ingredient("COTO", "Corn Tortilla", IngridientType.WRAP),
                new Ingredient("GRBF", "Ground Beef", IngridientType.PROTEIN),
                new Ingredient("CARN", "Carnitas", IngridientType.PROTEIN),
                new Ingredient("TMTO", "Diced Tomatoes", IngridientType.VEGGIES),
                new Ingredient("LETC", "Lettuce", IngridientType.VEGGIES),
                new Ingredient("CHED", "Cheddar", IngridientType.CHEESE),
                new Ingredient("JACK", "Monterrey Jack", IngridientType.CHEESE),
                new Ingredient("SLSA", "Salsa", IngridientType.SAUCE),
                new Ingredient("SRCR", "Sour Cream", IngridientType.SAUCE)
        );

        for (IngridientType type : IngridientType.values()) {
            model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
        }
    }

    /**
     * Создает новый заказ тако.
     * @return новый заказ тако.
     */
    @ModelAttribute("tacoOrder")
    public TacoOrder order() {
        return new TacoOrder();
    }

    @GetMapping
    public String showDesignForm() {
        return "design";
    }

    /**
     * Фильтрует ингредиенты по типу ингридиента.
     * @param ingredients ингридиенты.
     * @param ingredientType тип ингридиента.
     * @return коллекция отфильтрованных ингридиентов по типу.
     */
    private Iterable<Ingredient> filterByType(List<Ingredient> ingredients, IngridientType ingredientType) {
        return ingredients
                .stream()
                .filter(ingredient -> ingredient.getType().equals(ingredientType))
                .toList();
    }
}
