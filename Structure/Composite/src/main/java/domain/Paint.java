package domain;

/**
 * Paint.java
 * <p>
 * Description: [Add the description of the class]
 *
 * @author aleja
 * @since 02/01/2026
 */

public class Paint extends Product{
    private String color;

    public Paint(String name, double price, String color) {
        super(name, price);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return super.toString() + " Paint{" +
                "color='" + color + '\'' +
                '}';
    }
}
