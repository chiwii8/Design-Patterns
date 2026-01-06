package domain.strategy;

/**
 * HardLevel.java
 * <p>
 * Description: [Add the description of the class]
 *
 * @author aleja
 * @since 04/01/2026
 */

public class HardLevel extends LevelStrategy{
    @Override
    public void move() {
        System.out.println("The enemy move doing predictions of your attacks");
    }
}
