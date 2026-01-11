import domain.Enemy;
import domain.Entity;
import domain.Player;
import domain.visitor.Visitor;
import domain.visitor.VisitorDamage;

/**
 * Main.java
 * <p>
 * Description: Example using Visitor Pattern with player and enemy
 *
 * @author aleja
 * @since 05/01/2026
 */

public class Main {
    public static void main(String [] args){

        Entity player = new Player();
        Entity enemy = new Enemy();

        VisitorDamage visitorDamage = new VisitorDamage();

        player.accept(visitorDamage);
        enemy.accept(visitorDamage);
    }
}
