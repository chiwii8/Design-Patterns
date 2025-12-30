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
    public String Drive() {
        return "I'm driving my new Motorcycle.";
    }

    @Override
    public String Parking() {
        return "My Motorcycle is parked";
    }
}
