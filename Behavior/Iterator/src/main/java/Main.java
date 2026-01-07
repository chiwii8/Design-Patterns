import domain.Inventory;

import java.util.Iterator;

/**
 * Main.java
 *
 * @author aleja
 * @since 04/01/2026
 */

public class Main {
    public static void main(String [] args){
        Inventory inventory = new Inventory();
        Iterator<String> iterator = inventory.newIterator();

        while (iterator.hasNext()){
            System.out.println("Object: " + iterator.next());
        }
    }
}
