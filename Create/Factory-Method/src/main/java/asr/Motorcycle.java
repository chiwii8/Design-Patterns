package asr;

/**
 * Motorcycle.java
 * <p>
 * Description: [Add the description of the class]
 *
 * @author aleja
 * @since 30/12/2025
 */

public class Motorcycle implements Vehicle{

    @Override
    public String drive() {
        return "I'm driving my new Motorcycle.";
    }

    @Override
    public String parking() {
        return "My Motorcycle is parked";
    }
}
