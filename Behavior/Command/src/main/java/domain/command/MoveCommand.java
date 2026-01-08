package domain.command;

import domain.Player;

/**
 * MoveCommand.java
 * <p>
 * Description: Encapsulate a request to make the player move forward
 *
 * @author aleja
 * @since 04/01/2026
 */

public class MoveCommand implements Command{
    private Player player;

    public MoveCommand(Player player) {
        this.player = player;
    }

    @Override
    public void execute() {
        this.player.move();
    }
}
