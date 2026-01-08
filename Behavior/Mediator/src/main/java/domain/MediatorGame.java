package domain;

/**
 * MediatorGame.java
 * <p>
 * Description: [Add the description of the class]
 *
 * @author aleja
 * @since 04/01/2026
 */

public class MediatorGame implements Mediator{
    private Sound sound;
    private ResultAttack resultAttack;
    public MediatorGame(Sound sound, ResultAttack resultAttack) {
        this.sound = sound;
        this.resultAttack = resultAttack;
    }

    @Override
    public void notify(String event) {
        if(event.equalsIgnoreCase("PLAYER_ATTACK")){
            sound.reproduce();
        }else if(event.equalsIgnoreCase("ENEMY_DAMAGED"))
            this.resultAttack.result();
    }
}
