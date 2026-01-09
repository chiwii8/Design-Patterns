import domain.Player;
import domain.state.PoisonStatus;

/**
 * Main.java
 * <p>
 * Description: Example of State Pattern
 *
 * @author aleja
 * @since 05/01/2026
 */

public class Main {
    public static void main(String [] args){

        Player player = new Player();

        player.receiveDamage(20);

        //Chage manual status
        player.setStatus(new PoisonStatus());
        player.receiveDamage(40);

        player.receiveDamage(50);
    }
}
