package domain;

import domain.state.NormalState;
import domain.state.PlayerStatus;

/**
 * domain.Player.java
 * <p>
 * Description: Perform the received damage from the attacks using the different status
 *
 * @author aleja
 * @since 05/01/2026
 */

public class Player {
    private final int defaultLife = 100;
    private PlayerStatus status;
    private int life;

    public Player() {
        status = new NormalState();
        this.life = defaultLife;
    }

    public PlayerStatus getStatus() {
        return status;
    }

    public void setStatus(PlayerStatus status) {
        this.status = status;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public void receiveDamage(int damage){
        status.receiveDamage(this,damage);
    }
}
