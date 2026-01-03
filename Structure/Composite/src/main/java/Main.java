import domain.Component;
import domain.CompoundPacket;
import domain.Paint;

/**
 * Main.java
 * <p>
 * Description: Example of Composite Pattern, Using Package and Products.
 *
 * @author aleja
 * @since 02/01/2026
 */

public class Main {
    public static void main(String [] args){
        ///Default Values
        CompoundPacket mainPacket;
        CompoundPacket secondaryPacket;
        Component bluePaint;
        Component redPaint;
        Component greenPaint;

        ///Initialize variables
        mainPacket = new CompoundPacket();
        secondaryPacket = new CompoundPacket();

        bluePaint = new Paint("Blue-Aquamarine",10.99,"Aquamarine-12434");
        redPaint = new Paint("Red-Blood",15.32,"Red-23421");
        greenPaint = new Paint("Green-wood",5.23,"Green-11111");

        ///Add in the Packet
        mainPacket.addComponent(redPaint);
        secondaryPacket.addComponent(bluePaint);
        secondaryPacket.addComponent(greenPaint);


        mainPacket.addComponent(secondaryPacket);
        mainPacket.addComponent(new CompoundPacket());
        ///Verify Result
        System.out.println("Secundary Packet");
        secondaryPacket.Read();
        System.out.println("Total Price:" + secondaryPacket.TotalPrice() + "\n");

        System.out.println("Main Packet");
        mainPacket.Read();
        System.out.println("Total Price: " +mainPacket.TotalPrice());
    }
}
