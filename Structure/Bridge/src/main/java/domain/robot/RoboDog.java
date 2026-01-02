package domain.robot;

import domain.movement.MovementSystem;

/**
 * RoboDog.java
 * <p>
 * Description: This robot use {@link domain.movement.LegSystem} for {@link domain.movement.MovementSystem}
 *
 * @author aleja
 * @since 01/01/2026
 */

public class RoboDog  extends Robot{
    public RoboDog(MovementSystem movementSystem) {
        super(movementSystem);
    }

    @Override
    public void doTask() {
        System.out.println("The RoboDog start walking around the area");
        this.movementInstructions.forEach(this::move);
    }
}
