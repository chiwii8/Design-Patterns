package domain.strategy;

/**
 * MediumLevel.java
 * <p>
 * Description: [Add the description of the class]
 *
 * @author aleja
 * @since 04/01/2026
 */

public class MediumLevel extends LevelStrategy{
    @Override
    public void move() {
        System.out.println("The enemy move in zigzag");
    }
}
