import domain.Circle;
import domain.Rectangle;
import domain.Shape;

import java.util.ArrayList;
import java.util.List;

/**
 * main.java
 * <p>
 * Description: [Add the description of the class]
 *
 * @author aleja
 * @since 01/01/2026
 */

public class main {
    public static  void main(String [] args){
        //Define variables
        Circle circle;
        Rectangle rectangle;
        List<Shape> shapeList = new ArrayList<>();

        ///Initialize the objects
        circle = new Circle();
        circle.setColor("Red");
        circle.setX(5);
        circle.setY(10);

        circle.setRadius(10);

        rectangle = new Rectangle();
        rectangle.setColor("Blue");
        rectangle.setX(50);
        rectangle.setY(100);

        rectangle.setHeight(20);
        rectangle.setWidth(40);

        ///Add to the list
        shapeList.add(circle);
        shapeList.add(rectangle);

        ///Clone the Objects
        List<Shape> clonedList = new ArrayList<>();
        shapeList.forEach( shape -> clonedList.add(shape.clone()));

        ///Now we have a exact copy in the clonedList of the created shapes
    }
}
