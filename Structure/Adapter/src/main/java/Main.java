import domain.AdapterGameInput;
import domain.INewInputs;
import domain.OldControl;

/**
 * Main.java
 * <p>
 * Description: Example of the Adapter Pattern for that, we will translate the input of third party game
 * Inputs to adapt an old video games control
 *
 * @author aleja
 * @since 01/01/2026
 */

public class Main {
    public static void main(String [] args){
        ///Define variables
        OldControl control;
        INewInputs newControl;

        ///Initialize variables
        control = new OldControl();
        newControl = new AdapterGameInput(control);

        ///Now you can play the game without problems with the control
        newControl.move();
        newControl.jump();
    }

}
