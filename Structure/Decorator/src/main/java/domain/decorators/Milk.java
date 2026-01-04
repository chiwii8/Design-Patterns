package domain.decorators;

import domain.Drink;

/**
 * Milk.java
 * <p>
 * Description: [Add the description of the class]
 *
 * @author aleja
 * @since 02/01/2026
 */

public class Milk extends DrinkDecorator{

    public Milk(Drink drink) {
        super(drink);
    }

    @Override
    public String getDescription() {
        return drink.getDescription() + ", milk";
    }

    @Override
    public double getPrice() {
        return drink.getPrice() + 0.5;
    }
}
