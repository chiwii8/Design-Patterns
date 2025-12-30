package asr;

/**
 * Car.java
 * <p>
 * Description: Represents the Car object
 *
 * @author aleja
 * @since 30/12/2025
 */

public class Car implements Vehicle{
    public String Drive(){
        return "I'm driving my new car.";
    }

    @Override
    public String Parking() {
        return "My car is parked";
    }
}
