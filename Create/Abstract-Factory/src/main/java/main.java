import Abstract.AbstractFactory;
import Digital.DigitalFactory;
import Traditional.TraditionalFactory;

import java.util.Scanner;

/**
 * main.java
 * <p>
 * Description: Example of use of Abstract Factory using the Traditional and Digital art
 * We can do a regular picture or a portrait
 *
 * @author aleja
 * @since 31/12/2025
 */

public class main {

    public static void main(String [] args){
        ///Declaration of the variables
        AbstractFactory factory;
        Object element;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Do you want to use Traditional(t) or Digital(d) art?");
        char typeArt = scanner.next().charAt(0);

        ///default Traditional
        factory = selectTypeArt(typeArt);

        System.out.println("¿Do you need a picture(p) or a portrait(t)?");
        char typePicture = scanner.next().charAt(0);

        ///Default value Portrait
        element = CreateArt(typePicture,factory);

        System.out.println("The Element Create is " + element.getClass().getSimpleName());

    }


    private static AbstractFactory selectTypeArt(char type){
        if(type=='d')
            return new DigitalFactory();
        return new TraditionalFactory();
    }

    private static Object CreateArt(char type,AbstractFactory factory){
        if(type=='p')
            return factory.createPicture();
        return  factory.createPortrait();
    }
}
