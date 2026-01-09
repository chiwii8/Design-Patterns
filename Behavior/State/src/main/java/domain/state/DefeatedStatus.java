package domain.state;

import domain.Player;

/**
 * DefeatedStatus.java
 * <p>
 * Description: Performs the defeated status
 *
 * @author aleja
 * @since 05/01/2026
 */

public class DefeatedStatus implements PlayerStatus{

    @Override
    public void receiveDamage(Player player, int damage) {
        System.out.println("The player is defeated. Cant do nothing");
    }
}
