package domain.command;

import domain.Player;

/**
 * JumpCommand.java
 * <p>
 * Description: Encapsulate a request to make the player jump
 *
 * @author aleja
 * @since 04/01/2026
 */

public class JumpCommand implements Command{
    private Player player;

    public JumpCommand(Player player) {
        this.player = player;
    }

    @Override
    public void execute() {
        player.jump();
    }
}
