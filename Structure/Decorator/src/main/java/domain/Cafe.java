package domain;

/**
 * Cafe.java
 * <p>
 * Description: [Add the description of the class]
 *
 * @author aleja
 * @since 02/01/2026
 */

public class Cafe implements Drink{
    @Override
    public String getDescription() {
        return "Cafe";
    }

    @Override
    public double getPrice() {
        return 1.5;
    }
}
