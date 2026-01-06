package domain;

/**
 * HUD.java
 * <p>
 * Description: [Add the description of the class]
 *
 * @author aleja
 * @since 04/01/2026
 */

public class HUD implements Observer{
    @Override
    public void update(int life) {
        System.out.println("HUD: actual life: " + life);
    }
}
