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
    @Override
    public String drive(){
        return "I'm driving my new car.";
    }

    @Override
    public String parking() {
        return "My car is parked";
    }
}
