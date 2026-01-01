package domain;

/**
 * domain.Circle.java
 * <p>
 * Description: [Add the description of the class]
 *
 * @author aleja
 * @since 01/01/2026
 */

public class Circle extends Shape {
    private double radius;

    public Circle() {
    }

    public Circle(Circle circle){
        super(circle);
        this.radius = circle.radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public Shape clone() {
        return new Circle(this);
    }
}
