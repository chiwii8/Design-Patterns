import domain.HUD;
import domain.Observer;
import domain.Player;
import domain.Sound;

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
        ///Define variables
        Observer sound;
        Observer hud;
        Player player;

        ///Initialize variables
        sound = new Sound();
        hud = new HUD();
        player = new Player();

        player.addObserver(hud);
        player.addObserver(sound);

        player.receiveDamage(35);
        player.receiveDamage(40);
        player.receiveDamage(30);

        player.receiveDamage(100);
    }
}
