package domain.movement;

/**
 * WheelSystem.java
 * <p>
 * Description: Movement system without the limits with their action
 *
 * @author aleja
 * @since 01/01/2026
 */

public class WheelSystem implements MovementSystem{
    @Override
    public void forward() {
        System.out.println("The robot move forward");
    }

    @Override
    public void left() {
        System.out.println("The robot turn to left");
    }

    @Override
    public void right() {
        System.out.println("The robot turn to right");
    }

    @Override
    public void backtrack() {
        System.out.println("The robot move backtrack");
    }
}
