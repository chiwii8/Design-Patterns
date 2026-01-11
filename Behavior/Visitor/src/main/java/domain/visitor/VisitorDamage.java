package domain.visitor;

import domain.Enemy;
import domain.Player;

/**
 * VisitorDamage.java
 * <p>
 * Description: [Add the description of the class]
 *
 * @author aleja
 * @since 05/01/2026
 */

public class VisitorDamage implements Visitor{


    @Override
    public void visitPlayer(Player player) {
        System.out.println("Calculating damage to the player with life " + player.getlife());
    }

    @Override
    public void visitEnemy(Enemy enemy) {
        System.out.println("Calculating damage from the enemy with strength " + enemy.getStrength());
    }
}
