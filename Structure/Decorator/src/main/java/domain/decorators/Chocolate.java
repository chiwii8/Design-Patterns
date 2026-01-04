package domain.decorators;

import domain.Drink;

/**
 * Chocolate.java
 * <p>
 * Description: [Add the description of the class]
 *
 * @author aleja
 * @since 02/01/2026
 */

public class Chocolate extends DrinkDecorator{
    public Chocolate(Drink drink) {
        super(drink);
    }

    @Override
    public String getDescription() {
        return drink.getDescription() + ", chocolate";
    }

    @Override
    public double getPrice() {
        return drink.getPrice() + 0.75;
    }
}
