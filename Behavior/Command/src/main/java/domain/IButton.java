package domain;

import domain.command.Command;

///Describe the common method for all the buttons
public interface IButton {
    void setCommand(Command command);
    void press();
}
