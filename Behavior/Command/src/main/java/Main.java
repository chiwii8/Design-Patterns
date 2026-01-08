import domain.Button;
import domain.Player;
import domain.command.AttackCommand;
import domain.command.JumpCommand;
import domain.command.MoveCommand;

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
        Player player;
        Button button,button1;


        ///Initialize variables
        player = new Player();

        button = new Button();
        button.setCommand(new MoveCommand(player));

        button1 = new Button();
        button1.setCommand(new AttackCommand(player));

        button.press();
        button1.press();

        button.setCommand(new JumpCommand(player));

        button.press();

    }
}
