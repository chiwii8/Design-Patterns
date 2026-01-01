package domain;

/**
 * domain.Rectangle.java
 * <p>
 * Description: [Add the description of the class]
 *
 * @author aleja
 * @since 01/01/2026
 */

public class Rectangle extends Shape{
    private int width,height;

    public Rectangle() {}

    public Rectangle(Rectangle rectangle){
        super(rectangle);
        this.height = rectangle.height;
        this.width = rectangle.width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public Shape clone() {
        return new Rectangle(this);
    }
}
