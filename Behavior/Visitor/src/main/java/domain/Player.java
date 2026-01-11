package domain;

import domain.visitor.Visitor;

/**
 * Pla.java
 * <p>
 * Description: Perform the player visitor action
 *
 * @author aleja
 * @since 05/01/2026
 */

public class Player implements Entity {
    @Override
    public void accept(Visitor visitor) {
        visitor.visitPlayer(this);
    }

    public int getlife(){
        return 100;
    }
}
