package domain.decorators;

import domain.Drink;

/**
 * Base_Decorator.java
 * <p>
 * Description: [Add the description of the class]
 *
 * @author aleja
 * @since 02/01/2026
 */

public abstract class DrinkDecorator implements Drink{
    protected Drink drink;

    public DrinkDecorator(Drink drink) {
        this.drink = drink;
    }

}
