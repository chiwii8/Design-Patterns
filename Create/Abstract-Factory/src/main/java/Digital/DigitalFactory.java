package Digital;

import Abstract.AbstractFactory;
import Abstract.Picture;
import Abstract.Portrait;

/**
 * Digital.DigitalFactory.java
 * <p>
 * Description: [Add the description of the class]
 *
 * @author aleja
 * @since 31/12/2025
 */

public class DigitalFactory implements AbstractFactory {
    @Override
    public Picture createPicture() {
        return new DigitalPicture();
    }

    @Override
    public Portrait createPortrait() {
        return new DigitalPortrait();
    }
}
