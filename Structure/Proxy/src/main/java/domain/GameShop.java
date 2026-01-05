package domain;

/**
 * GameShop.java
 * <p>
 * Description: [Add the description of the class]
 *
 * @author aleja
 * @since 03/01/2026
 */

public class GameShop implements Shop{

    @Override
    public void buy(String item, double price) {
        System.out.println("You buy " + item + " sucessfully with the cost of " + price);
    }
}
