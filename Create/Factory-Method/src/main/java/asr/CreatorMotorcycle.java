package asr;

/**
 * Creatormotocycle.java
 * <p>
 * Description: [Add the description of the class]
 *
 * @author aleja
 * @since 30/12/2025
 */

public class CreatorMotorcycle extends CreatorVehicle{

    @Override
    public Vehicle CreateVehicle() {
        return new Motorcycle();
    }
}
