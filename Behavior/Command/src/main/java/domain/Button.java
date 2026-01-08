package domain;

import domain.command.Command;

/**
 * Button.java
 * <p>
 * Description: Triggers the command
 *
 * @author aleja
 * @since 04/01/2026
 */

public class Button implements IButton{
    private Command command;

    public Command getCommand() {
        return command;
    }

    @Override
    public void press() {
        command.execute();
    }

    public void setCommand(Command command) {
        this.command = command;
    }
}
