package domain;

import java.util.Iterator;

/**
 * Inventory.java
 * <p>
 *
 * @author aleja
 * @since 04/01/2026
 */

public class Inventory {
    private String [] objects = {
            "knife,potion,shield,key,arrows,bow"
    };

    public Iterator<String> newIterator(){
        return new IteratorInventory(objects);
    }
}
