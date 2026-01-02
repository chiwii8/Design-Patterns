package domain.robot;

import domain.movement.MovementSystem;

/**
 * CleanRobot.java
 * <p>
 * Description: This robot use {@link domain.movement.WheelSystem} for {@link domain.movement.MovementSystem}
 *
 * @author aleja
 * @since 01/01/2026
 */

public class CleanRobot extends Robot{

    public CleanRobot(MovementSystem movementSystem) {
        super(movementSystem);
    }

    @Override
    public void doTask() {
        System.out.println("The  Cleanrobot starts cleaning the area");
        this.movementInstructions.forEach(this::move);
    }
}
