package domain;

import java.util.Iterator;

/**
 * IteratorInventory.java
 *
 * @author aleja
 * @since 04/01/2026
 */

public class IteratorInventory implements Iterator<String> {
    private String [] objects;
    private int position = 0;

    public IteratorInventory(String [] objects) {
        super();
        this.objects = objects;
    }

    @Override
    public boolean hasNext() {
        return position < this.objects.length;
    }

    @Override
    public String next() {
        return objects[position++];
    }
}
