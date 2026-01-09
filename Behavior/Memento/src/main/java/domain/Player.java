package domain;

/**
 * Player.java
 * <p>
 * Description: Originator: player whose status could be saved/store
 *
 * @author aleja
 * @since 04/01/2026
 */

public class Player {
    private final int initLevel = 1;
    private final int defaultLife =100;

    private int life;
    private int level;

    public Player() {
        this.life = this.defaultLife;
        this.level = this.initLevel;
    }

    public Player(int life, int level) {
        this.life = life;
        this.level = level;
    }

    public void showStatus(){
        System.out.println("Player - Life: " + life + ", Level: " + level);
    }


    public void receiveDamage(int damage){
        this.life-=damage;
    }

    public void levelup(){
        this.level++;
    }


    public MementoPlayer save(){
        return new MementoPlayer(life,level);
    }

    public void load(MementoPlayer mementoPlayer){
        this.life = mementoPlayer.getLife();
        this.level = mementoPlayer.getLevel();
    }
}
