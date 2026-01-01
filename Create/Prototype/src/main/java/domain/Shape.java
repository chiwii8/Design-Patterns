package domain;

/**
 * domain.Shape.java
 * <p>
 * Description: [Add the description of the class]
 *
 * @author aleja
 * @since 01/01/2026
 */

public abstract class Shape implements Prototype{

    private String color;
    private int x,y;

    public Shape() {
    }

    public Shape(Shape shape){
        super();
        this.x = shape.x;
        this.y = shape.y;
        this.color = shape.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public abstract Shape clone();
}
