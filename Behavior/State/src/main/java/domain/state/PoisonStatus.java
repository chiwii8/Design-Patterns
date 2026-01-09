package domain.state;

import domain.Player;

/**
 * PoisonStatus.java
 * <p>
 * Description: Status that reduce constant 5 point of life
 *
 * @author aleja
 * @since 05/01/2026
 */

public class PoisonStatus implements PlayerStatus{
    @Override
    public void receiveDamage(Player player, int damage) {
        int posionDamage = 5; ///Const damage
        int actuallife = player.getLife() - damage - posionDamage;
        System.out.println("The player receive " + damage + " of damage");
        System.out.println("The poisoned player receive " + posionDamage + " of poison damage");

        player.setLife(actuallife);

        if(actuallife<=0){
            player.setStatus(new DefeatedStatus());
            System.out.println("Player defeated");
        }
    }
}
