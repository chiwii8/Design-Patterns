import domain.*;

/**
 * Main.java
 * <p>
 * Description: [Add the description of the class]
 *
 * @author aleja
 * @since 04/01/2026
 */

public class Main {

    public static void main(String [] args){
        Sound sound = new Sound();
        ResultAttack resultAttack = new ResultAttack();

        Mediator mediatorGame = new MediatorGame(sound,resultAttack);

        Player player = new Player(mediatorGame);
        Enemy enemy = new Enemy(mediatorGame);

        player.Attack();
        enemy.receiveAttack();
    }


}
