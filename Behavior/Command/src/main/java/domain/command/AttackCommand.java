package domain.command;

import domain.Player;

/**
 * AttackCommand.java
 * <p>
 * Description: Encapsulate a request to make the player attack
 *
 * @author aleja
 * @since 04/01/2026
 */

public class AttackCommand implements Command{
    private Player player;

    public AttackCommand(Player player) {
        this.player = player;
    }

    @Override
    public void execute() {
        player.attack();
    }
}
