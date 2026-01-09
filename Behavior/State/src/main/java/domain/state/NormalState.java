package domain.state;

import domain.Player;

/**
 * NormalState.java
 * <p>
 * Description: Describe the base status without effects
 *
 * @author aleja
 * @since 05/01/2026
 */

public class NormalState implements PlayerStatus{

    @Override
    public void receiveDamage(Player player, int damage) {
        player.setLife(player.getLife()-damage);
        System.out.println("The player receive " + damage + " of damage");

        if(player.getLife() <=0){
            player.setStatus(new DefeatedStatus());
            System.out.println("The player is defeated");
        }
    }
}
