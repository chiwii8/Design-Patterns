import domain.Player;
import domain.SaveStore;

/**
 * Main.java
 * <p>
 * Description: Example of Mememto of Design Patterns using a player that can save and load a status
 *
 * @author aleja
 * @since 04/01/2026
 */

public class Main {
    public static void main(String [] args){
        Player player = new Player();
        SaveStore saveStore = new SaveStore();

        player.showStatus();

        saveStore.save(player.save());

        player.receiveDamage(30);
        player.levelup();
        player.showStatus();


        player.load(saveStore.undo());
        player.showStatus();
    }
}
