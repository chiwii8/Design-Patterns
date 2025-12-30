package asr;

/**
 * CreatorCar.java
 * <p>
 * Description: [Add the description of the class]
 *
 * @author aleja
 * @since 30/12/2025
 */

public class CreatorCar extends CreatorVehicle{

    @Override
    public Vehicle CreateVehicle() {
        return new Car();
    }
}
