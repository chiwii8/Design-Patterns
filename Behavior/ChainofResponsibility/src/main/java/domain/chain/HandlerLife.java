package domain.chain;

import domain.Life;

/**
 * HandlerLife.java
 * <p>
 * Description: Control and reduce life
 *
 * @author aleja
 * @since 04/01/2026
 */

public class HandlerLife extends HandlerDamage{

    private Life life;

    public HandlerLife() {
        this.life = new Life();
    }

    @Override
    public void processDamage(int damage) {
        this.life.receiveDamage(damage);
    }
}
