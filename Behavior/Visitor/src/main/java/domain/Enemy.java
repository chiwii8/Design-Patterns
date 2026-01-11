package domain;

import domain.visitor.Visitor;

/**
 * Enemy.java
 * <p>
 * Description: Perform the enemy visitor action
 *
 * @author aleja
 * @since 05/01/2026
 */

public class Enemy implements Entity{
    @Override
    public void accept(Visitor visitor) {
        visitor.visitEnemy(this);
    }

    public int getStrength(){
        return 30;
    }
}
