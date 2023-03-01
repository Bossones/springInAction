package ru.bossones.secondchapter.controller;

import static ru.bossones.secondchapter.model.Ingredient.INGREDIENTS;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import ru.bossones.secondchapter.model.Ingredient;
import ru.bossones.secondchapter.model.Taco;
import ru.bossones.secondchapter.model.TacoOrder;
import ru.bossones.secondchapter.model.enums.IngredientType;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("tacoOrder")
public class DesignTacoController {

    /**
     * Данный метод выполняется также, когда перехватывается и обрабатывается запрос /design.
     * Создает список ингридиентов, которые передаются в модель.
     * После того, как все будет добавлено в модель, то выполняется метод showDesignForm.
     *
     * @param model модель.
     */
    @ModelAttribute
    public void addIngredientsToModel(Model model) {
        for (IngredientType type : IngredientType.values()) {
            model.addAttribute(type.toString().toLowerCase(), filterByType(INGREDIENTS, type));
        }
    }

    /**
     * Создает новый заказ тако.
     * @return новый заказ тако.
     *
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
     * Обрабатывает submit метод в design.html при сборке тако.
     * @param taco собраный тако.
     * @param tacoOrder заказ Тако, остающийся в сессии пользователя.
     * @return редирект на /orders/current
     */
    @PostMapping
    public String processTaco(Taco taco, @ModelAttribute TacoOrder tacoOrder) {
        tacoOrder.addTaco(taco);
        log.info("Processing taco: {}", taco);
        return "redirect:/orders/current";
    }

    /**
     * Фильтрует ингредиенты по типу ингридиента.
     * @param ingredients ингридиенты.
     * @param ingredientType тип ингридиента.
     * @return коллекция отфильтрованных ингридиентов по типу.
     */
    private Iterable<Ingredient> filterByType(List<Ingredient> ingredients, IngredientType ingredientType) {
        return ingredients
                .stream()
                .filter(ingredient -> ingredient.getType().equals(ingredientType))
                .toList();
    }
}
