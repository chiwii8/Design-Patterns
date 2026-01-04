import domain.Cafe;
import domain.Drink;
import domain.decorators.Chocolate;
import domain.decorators.Milk;

/**
 * Main.java
 * <p>
 * Description: [Add the description of the class]
 *
 * @author aleja
 * @since 02/01/2026
 */

public class Main {
    public static void main(String [] args){
        Drink cafe = new Cafe();
        System.out.println(cafe.getDescription() + "-> " + cafe.getPrice());

        cafe = new Milk(cafe);
        cafe = new Chocolate(cafe);

        System.out.println(cafe.getDescription() + "-> " + cafe.getPrice());
    }
}
