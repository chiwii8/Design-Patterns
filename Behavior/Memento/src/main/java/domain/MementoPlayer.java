package domain;

/**
 * MementoPlayer.java
 * <p>
 * Description: Memento: store the status of the player
 *
 * @author aleja
 * @since 04/01/2026
 */

public class MementoPlayer {


    private int life;
    private int level;

    public MementoPlayer(int life, int level) {
        this.life = life;
        this.level = level;
    }

    public int getLife() {
        return life;
    }

    public int getLevel() {
        return level;
    }
}
