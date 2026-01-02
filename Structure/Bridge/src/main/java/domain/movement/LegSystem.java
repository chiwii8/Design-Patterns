package domain.movement;

/**
 * legSystem.java
 * <p>
 * Description: Movement System that limit the backtrack movement, for that, you need to turn left, and move forward
 *
 * @author aleja
 * @since 01/01/2026
 */

public class LegSystem implements MovementSystem{
    @Override
    public void forward() {
        System.out.println("The robot walk forward");
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
        System.out.println("The robot start turn 180 degrees to the left ");
        left();
        forward();
    }
}
