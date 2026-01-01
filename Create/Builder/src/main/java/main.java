import domain.House;
import domain.HouseDirector;

/**
 * main.java
 * <p>
 * Description: Example of use of Builder Pattern, better use in bigger projects when we need a better structure
 *
 * @author aleja
 * @since 01/01/2026
 */

public class main {
    public static void main(String [] args){
        House lowerHouse,luxuryHouse;

        try {
            lowerHouse = HouseDirector.createHouse("lowpricehouse");
            luxuryHouse = HouseDirector.createHouse("luxuryhouse");
            System.out.println("The Different house was sucessfull created");
            System.out.println(lowerHouse.toString());
            System.out.println(luxuryHouse.toString());
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

    }
}
