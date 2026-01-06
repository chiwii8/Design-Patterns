package domain;

/**
 * Sound.java
 * <p>
 * Description: [Add the description of the class]
 *
 * @author aleja
 * @since 04/01/2026
 */

public class Sound implements Observer{
    @Override
    public void update(int life) {
        if(life>50)
            System.out.println("I'm ready for more");
        else if(life>0)
            System.out.println("I need to finish quick this battle");
        else
            System.out.println("How can i lose?");
    }
}
