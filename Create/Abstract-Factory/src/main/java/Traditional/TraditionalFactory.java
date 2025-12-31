package Traditional;

import Abstract.AbstractFactory;
import Abstract.Picture;
import Abstract.Portrait;

/**
 * Traditional.TraditionalFactory.java
 * <p>
 * Description: [Add the description of the class]
 *
 * @author aleja
 * @since 31/12/2025
 */

public class TraditionalFactory implements AbstractFactory {
    @Override
    public Picture createPicture() {
        return new TraditionalPicture();
    }

    @Override
    public Portrait createPortrait() {
        return new TraditionalPortrait();
    }
}
