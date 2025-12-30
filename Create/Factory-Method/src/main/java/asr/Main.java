package asr;

import java.util.Scanner;

/**
 * Basic Example using a factory method
 * In this case we have a vehicle that can be parked or is using for drive
 */
public class Main {
    public static void main(String[] args) {

        ///Default Variables
        CreatorVehicle creatorVehicle;
        Vehicle vehicle;


        ///Ask for the type of vehicle is using, for default use is Car
        System.out.println("¿What is your Vehicle?(m or c)");

        ///Read the result and create the Concrete Creator
        Scanner scanner = new Scanner(System.in);
        char type = scanner.next().charAt(0);
        if(type == 'm')
            creatorVehicle = new CreatorMotorcycle();
        else
            creatorVehicle = new CreatorCar();

        /// Create a new Vehicle with the Concrete Creator
        vehicle = creatorVehicle.CreateVehicle();

        ///Ask for if he is driving or parked, for default use is Parked
        System.out.println("¿Are you driving or your vehicle is parked? (d or p)");
        char vehicleStatus = scanner.next().charAt(0);

        if(vehicleStatus == 'd')
            System.out.println(vehicle.Drive());
        else
            System.out.println(vehicle.Parking());

    }
}
