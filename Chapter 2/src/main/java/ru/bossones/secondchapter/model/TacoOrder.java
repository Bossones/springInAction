package ru.bossones.secondchapter.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Заказ Тако. Содержит в себе информацию о заказе (куда доставлять, кому доставлять и т.п.)
 */
@Data
public class TacoOrder {

    private String deliveryName;
    private String deliveryStreet;
    private String deliveryCity;
    private String deliveryState;
    private String deliveryZip;
    private String ccNumber;
    private String ccExpiration;
    private String ccCVV;

    private List<Taco> tacos = new ArrayList<>();

    /**
     * Добавляет выбранный тако в заказ.
     * @param taco выбранный тако.
     */
    public void addTaco(Taco taco) {
        tacos.add(taco);
    }
}
