package domain;

/**
 * Enemy.java
 * <p>
 * Description: Perform the action of receive the attack from the player
 *
 * @author aleja
 * @since 04/01/2026
 */

public class Enemy {
    Mediator mediator;

    public Enemy(Mediator mediator) {
        this.mediator = mediator;
    }

    public void receiveAttack(){
        System.out.println("The enemy receive damage");
        mediator.notify("ENEMY_DAMAGED");
    }
}
