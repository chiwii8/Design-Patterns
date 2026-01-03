package domain;

/**
 * AdapterGameInput.java
 * <p>
 * Description: Connect the new input for use in the old control
 *
 * @author aleja
 * @since 01/01/2026
 */

public class AdapterGameInput  implements INewInputs {
    private OldControl control;

    public AdapterGameInput(OldControl control){
        this.control = control;
    }

    @Override
    public void move() {
        control.up();
    }

    @Override
    public void jump() {
        control.pressA();
    }
}
