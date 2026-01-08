package domain;

/**
 * Player.java
 * <p>
 * Description: Perform the player attack action
 *
 * @author aleja
 * @since 04/01/2026
 */

public class Player {
    Mediator mediator;

    public Player(Mediator mediator) {
        this.mediator = mediator;
    }

    public void Attack(){
        System.out.println("Player attack");
        this.mediator.notify("PLAYER_ATTACK");
    }
}
